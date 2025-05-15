import grpc
from server import llm_pb2, llm_pb2_grpc


def run():
    with grpc.insecure_channel('localhost:50051') as channel:
        stub = llm_pb2_grpc.LLMServiceStub(channel)
        response = stub.GetLLM(llm_pb2.GetLLMRequest(input="你好，请介绍一下你自己"))
        print("模型回复：", response.output)

if __name__ == '__main__':
    run()
