// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: calculator/calculator.proto

package com.proto.calculator;

public final class Calculator {
  private Calculator() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dummy_SumRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dummy_SumRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dummy_SumResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dummy_SumResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\033calculator/calculator.proto\022\005dummy\"9\n\n" +
      "SumRequest\022\024\n\014first_number\030\001 \001(\005\022\025\n\rseco" +
      "nd_number\030\002 \001(\005\"!\n\013SumResponse\022\022\n\nsum_re" +
      "sult\030\001 \001(\0052C\n\021CalculatorService\022.\n\003Sum\022\021" +
      ".dummy.SumRequest\032\022.dummy.SumResponse\"\000B" +
      "\030\n\024com.proto.calculatorP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_dummy_SumRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_dummy_SumRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dummy_SumRequest_descriptor,
        new java.lang.String[] { "FirstNumber", "SecondNumber", });
    internal_static_dummy_SumResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_dummy_SumResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dummy_SumResponse_descriptor,
        new java.lang.String[] { "SumResult", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
