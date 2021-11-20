package chat;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.1)",
    comments = "Source: chat.proto")
public final class ServerProviderGrpc {

  private ServerProviderGrpc() {}

  public static final String SERVICE_NAME = "forum.ServerProvider";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      chat.EndPoint> getRequestServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "requestServer",
      requestType = com.google.protobuf.Empty.class,
      responseType = chat.EndPoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      chat.EndPoint> getRequestServerMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, chat.EndPoint> getRequestServerMethod;
    if ((getRequestServerMethod = ServerProviderGrpc.getRequestServerMethod) == null) {
      synchronized (ServerProviderGrpc.class) {
        if ((getRequestServerMethod = ServerProviderGrpc.getRequestServerMethod) == null) {
          ServerProviderGrpc.getRequestServerMethod = getRequestServerMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, chat.EndPoint>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "requestServer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chat.EndPoint.getDefaultInstance()))
              .setSchemaDescriptor(new ServerProviderMethodDescriptorSupplier("requestServer"))
              .build();
        }
      }
    }
    return getRequestServerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServerProviderStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerProviderStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerProviderStub>() {
        @java.lang.Override
        public ServerProviderStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerProviderStub(channel, callOptions);
        }
      };
    return ServerProviderStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServerProviderBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerProviderBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerProviderBlockingStub>() {
        @java.lang.Override
        public ServerProviderBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerProviderBlockingStub(channel, callOptions);
        }
      };
    return ServerProviderBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServerProviderFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerProviderFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerProviderFutureStub>() {
        @java.lang.Override
        public ServerProviderFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerProviderFutureStub(channel, callOptions);
        }
      };
    return ServerProviderFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ServerProviderImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Client will request a server, getting the EndPoint in return
     * </pre>
     */
    public void requestServer(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<chat.EndPoint> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestServerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestServerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                chat.EndPoint>(
                  this, METHODID_REQUEST_SERVER)))
          .build();
    }
  }

  /**
   */
  public static final class ServerProviderStub extends io.grpc.stub.AbstractAsyncStub<ServerProviderStub> {
    private ServerProviderStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerProviderStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerProviderStub(channel, callOptions);
    }

    /**
     * <pre>
     * Client will request a server, getting the EndPoint in return
     * </pre>
     */
    public void requestServer(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<chat.EndPoint> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRequestServerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ServerProviderBlockingStub extends io.grpc.stub.AbstractBlockingStub<ServerProviderBlockingStub> {
    private ServerProviderBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerProviderBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerProviderBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Client will request a server, getting the EndPoint in return
     * </pre>
     */
    public chat.EndPoint requestServer(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getRequestServerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ServerProviderFutureStub extends io.grpc.stub.AbstractFutureStub<ServerProviderFutureStub> {
    private ServerProviderFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerProviderFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerProviderFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Client will request a server, getting the EndPoint in return
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<chat.EndPoint> requestServer(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getRequestServerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_SERVER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServerProviderImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServerProviderImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_SERVER:
          serviceImpl.requestServer((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<chat.EndPoint>) responseObserver);
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

  private static abstract class ServerProviderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServerProviderBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return chat.Chat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServerProvider");
    }
  }

  private static final class ServerProviderFileDescriptorSupplier
      extends ServerProviderBaseDescriptorSupplier {
    ServerProviderFileDescriptorSupplier() {}
  }

  private static final class ServerProviderMethodDescriptorSupplier
      extends ServerProviderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServerProviderMethodDescriptorSupplier(String methodName) {
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
      synchronized (ServerProviderGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServerProviderFileDescriptorSupplier())
              .addMethod(getRequestServerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
