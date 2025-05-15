package com.uta.javaclient.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.72.0)",
    comments = "Source: llm.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LLMServiceGrpc {

  private LLMServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "server.LLMService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.uta.javaclient.rpc.GetLLMRequest,
      com.uta.javaclient.rpc.GetLLMResp> getGetLLMMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLLM",
      requestType = com.uta.javaclient.rpc.GetLLMRequest.class,
      responseType = com.uta.javaclient.rpc.GetLLMResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.uta.javaclient.rpc.GetLLMRequest,
      com.uta.javaclient.rpc.GetLLMResp> getGetLLMMethod() {
    io.grpc.MethodDescriptor<com.uta.javaclient.rpc.GetLLMRequest, com.uta.javaclient.rpc.GetLLMResp> getGetLLMMethod;
    if ((getGetLLMMethod = LLMServiceGrpc.getGetLLMMethod) == null) {
      synchronized (LLMServiceGrpc.class) {
        if ((getGetLLMMethod = LLMServiceGrpc.getGetLLMMethod) == null) {
          LLMServiceGrpc.getGetLLMMethod = getGetLLMMethod =
              io.grpc.MethodDescriptor.<com.uta.javaclient.rpc.GetLLMRequest, com.uta.javaclient.rpc.GetLLMResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLLM"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.uta.javaclient.rpc.GetLLMRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.uta.javaclient.rpc.GetLLMResp.getDefaultInstance()))
              .setSchemaDescriptor(new LLMServiceMethodDescriptorSupplier("GetLLM"))
              .build();
        }
      }
    }
    return getGetLLMMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LLMServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LLMServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LLMServiceStub>() {
        @java.lang.Override
        public LLMServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LLMServiceStub(channel, callOptions);
        }
      };
    return LLMServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static LLMServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LLMServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LLMServiceBlockingV2Stub>() {
        @java.lang.Override
        public LLMServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LLMServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return LLMServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LLMServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LLMServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LLMServiceBlockingStub>() {
        @java.lang.Override
        public LLMServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LLMServiceBlockingStub(channel, callOptions);
        }
      };
    return LLMServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LLMServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LLMServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LLMServiceFutureStub>() {
        @java.lang.Override
        public LLMServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LLMServiceFutureStub(channel, callOptions);
        }
      };
    return LLMServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getLLM(com.uta.javaclient.rpc.GetLLMRequest request,
        io.grpc.stub.StreamObserver<com.uta.javaclient.rpc.GetLLMResp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLLMMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LLMService.
   */
  public static abstract class LLMServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LLMServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LLMService.
   */
  public static final class LLMServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LLMServiceStub> {
    private LLMServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LLMServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LLMServiceStub(channel, callOptions);
    }

    /**
     */
    public void getLLM(com.uta.javaclient.rpc.GetLLMRequest request,
        io.grpc.stub.StreamObserver<com.uta.javaclient.rpc.GetLLMResp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLLMMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LLMService.
   */
  public static final class LLMServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<LLMServiceBlockingV2Stub> {
    private LLMServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LLMServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LLMServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.uta.javaclient.rpc.GetLLMResp getLLM(com.uta.javaclient.rpc.GetLLMRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLLMMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service LLMService.
   */
  public static final class LLMServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LLMServiceBlockingStub> {
    private LLMServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LLMServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LLMServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.uta.javaclient.rpc.GetLLMResp getLLM(com.uta.javaclient.rpc.GetLLMRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLLMMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LLMService.
   */
  public static final class LLMServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LLMServiceFutureStub> {
    private LLMServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LLMServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LLMServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.uta.javaclient.rpc.GetLLMResp> getLLM(
        com.uta.javaclient.rpc.GetLLMRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLLMMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LLM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LLM:
          serviceImpl.getLLM((com.uta.javaclient.rpc.GetLLMRequest) request,
              (io.grpc.stub.StreamObserver<com.uta.javaclient.rpc.GetLLMResp>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetLLMMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.uta.javaclient.rpc.GetLLMRequest,
              com.uta.javaclient.rpc.GetLLMResp>(
                service, METHODID_GET_LLM)))
        .build();
  }

  private static abstract class LLMServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LLMServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.uta.javaclient.rpc.GetLLMServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LLMService");
    }
  }

  private static final class LLMServiceFileDescriptorSupplier
      extends LLMServiceBaseDescriptorSupplier {
    LLMServiceFileDescriptorSupplier() {}
  }

  private static final class LLMServiceMethodDescriptorSupplier
      extends LLMServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LLMServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LLMServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LLMServiceFileDescriptorSupplier())
              .addMethod(getGetLLMMethod())
              .build();
        }
      }
    }
    return result;
  }
}
