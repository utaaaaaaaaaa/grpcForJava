# python服务端代码
import time
from concurrent import futures
import grpc
import requests
from pydantic import BaseModel

import llm_pb2
import llm_pb2_grpc


class LLMServiceServicer(llm_pb2_grpc.LLMServiceServicer):

    class ChatRequest(BaseModel):
        prompt: str
        model: str = "mistral:7b-instruct"  # 默认使用mistral模型
        temperature: float = 0.7
        top_k: int = 50

    # 同步版本推荐
    def chat(self, request: ChatRequest):
        response = requests.post(
            "http://localhost:11434/api/generate",
            json={
                "model": request.model,
                "prompt": request.prompt,
                "stream": False,
            },
            timeout=60
        )
        response.raise_for_status()
        return response.json()["response"]

    def GetLLM(self, request, context):
        req = self.ChatRequest(prompt=request.input)
        chat_resp = self.chat(req)
        return llm_pb2.GetLLMResp(output=chat_resp)


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    llm_pb2_grpc.add_LLMServiceServicer_to_server(LLMServiceServicer(), server)
    server.add_insecure_port('[::]:50051')
    server.start()
    try:
        while True:
            time.sleep(3600)
    except KeyboardInterrupt:
        server.stop(0)


if __name__ == '__main__':
    print("Starting server. Listening on port 50051.")
    serve()