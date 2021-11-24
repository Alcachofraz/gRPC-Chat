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
public final class ShareGrpc {

  private ShareGrpc() {}

  public static final String SERVICE_NAME = "forum.Share";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<chat.SharedMessage,
      com.google.protobuf.Empty> getShareMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "shareMessage",
      requestType = chat.SharedMessage.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<chat.SharedMessage,
      com.google.protobuf.Empty> getShareMessageMethod() {
    io.grpc.MethodDescriptor<chat.SharedMessage, com.google.protobuf.Empty> getShareMessageMethod;
    if ((getShareMessageMethod = ShareGrpc.getShareMessageMethod) == null) {
      synchronized (ShareGrpc.class) {
        if ((getShareMessageMethod = ShareGrpc.getShareMessageMethod) == null) {
          ShareGrpc.getShareMessageMethod = getShareMessageMethod =
              io.grpc.MethodDescriptor.<chat.SharedMessage, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "shareMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chat.SharedMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ShareMethodDescriptorSupplier("shareMessage"))
              .build();
        }
      }
    }
    return getShareMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ShareStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ShareStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ShareStub>() {
        @java.lang.Override
        public ShareStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ShareStub(channel, callOptions);
        }
      };
    return ShareStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ShareBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ShareBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ShareBlockingStub>() {
        @java.lang.Override
        public ShareBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ShareBlockingStub(channel, callOptions);
        }
      };
    return ShareBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ShareFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ShareFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ShareFutureStub>() {
        @java.lang.Override
        public ShareFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ShareFutureStub(channel, callOptions);
        }
      };
    return ShareFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ShareImplBase implements io.grpc.BindableService {

    /**
     */
    public void shareMessage(chat.SharedMessage request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getShareMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getShareMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                chat.SharedMessage,
                com.google.protobuf.Empty>(
                  this, METHODID_SHARE_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class ShareStub extends io.grpc.stub.AbstractAsyncStub<ShareStub> {
    private ShareStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShareStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ShareStub(channel, callOptions);
    }

    /**
     */
    public void shareMessage(chat.SharedMessage request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getShareMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ShareBlockingStub extends io.grpc.stub.AbstractBlockingStub<ShareBlockingStub> {
    private ShareBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShareBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ShareBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty shareMessage(chat.SharedMessage request) {
      return blockingUnaryCall(
          getChannel(), getShareMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ShareFutureStub extends io.grpc.stub.AbstractFutureStub<ShareFutureStub> {
    private ShareFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShareFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ShareFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> shareMessage(
        chat.SharedMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getShareMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SHARE_MESSAGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ShareImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ShareImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SHARE_MESSAGE:
          serviceImpl.shareMessage((chat.SharedMessage) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private static abstract class ShareBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ShareBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return chat.Chat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Share");
    }
  }

  private static final class ShareFileDescriptorSupplier
      extends ShareBaseDescriptorSupplier {
    ShareFileDescriptorSupplier() {}
  }

  private static final class ShareMethodDescriptorSupplier
      extends ShareBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ShareMethodDescriptorSupplier(String methodName) {
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
      synchronized (ShareGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ShareFileDescriptorSupplier())
              .addMethod(getShareMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
