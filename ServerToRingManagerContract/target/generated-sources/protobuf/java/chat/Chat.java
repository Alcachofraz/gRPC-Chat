// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package chat;

public final class Chat {
  private Chat() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_forum_EndPoint_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_forum_EndPoint_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nchat.proto\022\005forum\"$\n\010EndPoint\022\n\n\002ip\030\001 " +
      "\001(\t\022\014\n\004port\030\002 \001(\00524\n\006Enroll\022*\n\006enroll\022\017." +
      "forum.EndPoint\032\017.forum.EndPointB\010\n\004chatP" +
      "\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_forum_EndPoint_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_forum_EndPoint_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_forum_EndPoint_descriptor,
        new java.lang.String[] { "Ip", "Port", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
