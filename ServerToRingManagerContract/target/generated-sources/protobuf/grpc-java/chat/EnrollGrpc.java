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
public final class EnrollGrpc {

  private EnrollGrpc() {}

  public static final String SERVICE_NAME = "forum.Enroll";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<chat.EndPoint,
      chat.EndPoint> getEnrollMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "enroll",
      requestType = chat.EndPoint.class,
      responseType = chat.EndPoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<chat.EndPoint,
      chat.EndPoint> getEnrollMethod() {
    io.grpc.MethodDescriptor<chat.EndPoint, chat.EndPoint> getEnrollMethod;
    if ((getEnrollMethod = EnrollGrpc.getEnrollMethod) == null) {
      synchronized (EnrollGrpc.class) {
        if ((getEnrollMethod = EnrollGrpc.getEnrollMethod) == null) {
          EnrollGrpc.getEnrollMethod = getEnrollMethod =
              io.grpc.MethodDescriptor.<chat.EndPoint, chat.EndPoint>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "enroll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chat.EndPoint.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chat.EndPoint.getDefaultInstance()))
              .setSchemaDescriptor(new EnrollMethodDescriptorSupplier("enroll"))
              .build();
        }
      }
    }
    return getEnrollMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EnrollStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnrollStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnrollStub>() {
        @java.lang.Override
        public EnrollStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnrollStub(channel, callOptions);
        }
      };
    return EnrollStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EnrollBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnrollBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnrollBlockingStub>() {
        @java.lang.Override
        public EnrollBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnrollBlockingStub(channel, callOptions);
        }
      };
    return EnrollBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EnrollFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnrollFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnrollFutureStub>() {
        @java.lang.Override
        public EnrollFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnrollFutureStub(channel, callOptions);
        }
      };
    return EnrollFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class EnrollImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Server will enroll with its own EndPoint,
     * and get the 'next' server's EndPoint
     * </pre>
     */
    public void enroll(chat.EndPoint request,
        io.grpc.stub.StreamObserver<chat.EndPoint> responseObserver) {
      asyncUnimplementedUnaryCall(getEnrollMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEnrollMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                chat.EndPoint,
                chat.EndPoint>(
                  this, METHODID_ENROLL)))
          .build();
    }
  }

  /**
   */
  public static final class EnrollStub extends io.grpc.stub.AbstractAsyncStub<EnrollStub> {
    private EnrollStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnrollStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnrollStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server will enroll with its own EndPoint,
     * and get the 'next' server's EndPoint
     * </pre>
     */
    public void enroll(chat.EndPoint request,
        io.grpc.stub.StreamObserver<chat.EndPoint> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEnrollMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EnrollBlockingStub extends io.grpc.stub.AbstractBlockingStub<EnrollBlockingStub> {
    private EnrollBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnrollBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnrollBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server will enroll with its own EndPoint,
     * and get the 'next' server's EndPoint
     * </pre>
     */
    public chat.EndPoint enroll(chat.EndPoint request) {
      return blockingUnaryCall(
          getChannel(), getEnrollMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EnrollFutureStub extends io.grpc.stub.AbstractFutureStub<EnrollFutureStub> {
    private EnrollFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnrollFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnrollFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server will enroll with its own EndPoint,
     * and get the 'next' server's EndPoint
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<chat.EndPoint> enroll(
        chat.EndPoint request) {
      return futureUnaryCall(
          getChannel().newCall(getEnrollMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ENROLL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EnrollImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EnrollImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ENROLL:
          serviceImpl.enroll((chat.EndPoint) request,
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

  private static abstract class EnrollBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EnrollBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return chat.Chat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Enroll");
    }
  }

  private static final class EnrollFileDescriptorSupplier
      extends EnrollBaseDescriptorSupplier {
    EnrollFileDescriptorSupplier() {}
  }

  private static final class EnrollMethodDescriptorSupplier
      extends EnrollBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EnrollMethodDescriptorSupplier(String methodName) {
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
      synchronized (EnrollGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EnrollFileDescriptorSupplier())
              .addMethod(getEnrollMethod())
              .build();
        }
      }
    }
    return result;
  }
}
