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
public final class BroadcastGrpc {

  private BroadcastGrpc() {}

  public static final String SERVICE_NAME = "forum.Broadcast";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<chat.BroadcastMessage,
      com.google.protobuf.Empty> getBroadcastMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "broadcastMessage",
      requestType = chat.BroadcastMessage.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<chat.BroadcastMessage,
      com.google.protobuf.Empty> getBroadcastMessageMethod() {
    io.grpc.MethodDescriptor<chat.BroadcastMessage, com.google.protobuf.Empty> getBroadcastMessageMethod;
    if ((getBroadcastMessageMethod = BroadcastGrpc.getBroadcastMessageMethod) == null) {
      synchronized (BroadcastGrpc.class) {
        if ((getBroadcastMessageMethod = BroadcastGrpc.getBroadcastMessageMethod) == null) {
          BroadcastGrpc.getBroadcastMessageMethod = getBroadcastMessageMethod =
              io.grpc.MethodDescriptor.<chat.BroadcastMessage, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "broadcastMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chat.BroadcastMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BroadcastMethodDescriptorSupplier("broadcastMessage"))
              .build();
        }
      }
    }
    return getBroadcastMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BroadcastStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BroadcastStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BroadcastStub>() {
        @java.lang.Override
        public BroadcastStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BroadcastStub(channel, callOptions);
        }
      };
    return BroadcastStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BroadcastBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BroadcastBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BroadcastBlockingStub>() {
        @java.lang.Override
        public BroadcastBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BroadcastBlockingStub(channel, callOptions);
        }
      };
    return BroadcastBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BroadcastFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BroadcastFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BroadcastFutureStub>() {
        @java.lang.Override
        public BroadcastFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BroadcastFutureStub(channel, callOptions);
        }
      };
    return BroadcastFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BroadcastImplBase implements io.grpc.BindableService {

    /**
     */
    public void broadcastMessage(chat.BroadcastMessage request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getBroadcastMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBroadcastMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                chat.BroadcastMessage,
                com.google.protobuf.Empty>(
                  this, METHODID_BROADCAST_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class BroadcastStub extends io.grpc.stub.AbstractAsyncStub<BroadcastStub> {
    private BroadcastStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BroadcastStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BroadcastStub(channel, callOptions);
    }

    /**
     */
    public void broadcastMessage(chat.BroadcastMessage request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBroadcastMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BroadcastBlockingStub extends io.grpc.stub.AbstractBlockingStub<BroadcastBlockingStub> {
    private BroadcastBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BroadcastBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BroadcastBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty broadcastMessage(chat.BroadcastMessage request) {
      return blockingUnaryCall(
          getChannel(), getBroadcastMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BroadcastFutureStub extends io.grpc.stub.AbstractFutureStub<BroadcastFutureStub> {
    private BroadcastFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BroadcastFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BroadcastFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> broadcastMessage(
        chat.BroadcastMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getBroadcastMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BROADCAST_MESSAGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BroadcastImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BroadcastImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BROADCAST_MESSAGE:
          serviceImpl.broadcastMessage((chat.BroadcastMessage) request,
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

  private static abstract class BroadcastBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BroadcastBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return chat.Chat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Broadcast");
    }
  }

  private static final class BroadcastFileDescriptorSupplier
      extends BroadcastBaseDescriptorSupplier {
    BroadcastFileDescriptorSupplier() {}
  }

  private static final class BroadcastMethodDescriptorSupplier
      extends BroadcastBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BroadcastMethodDescriptorSupplier(String methodName) {
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
      synchronized (BroadcastGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BroadcastFileDescriptorSupplier())
              .addMethod(getBroadcastMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
