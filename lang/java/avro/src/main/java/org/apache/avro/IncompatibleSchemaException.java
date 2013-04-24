package org.apache.avro;

import java.io.StringWriter;

public class IncompatibleSchemaException extends Exception {
      private Schema parent;
      private Schema child;

      public IncompatibleSchemaException(String message, Schema parent, Schema child) {
          super(message);
          if (parent == null || child == null) {
              throw new IllegalArgumentException("Parent and child schemas must be provided.");
          }
          this.parent = parent;
          this.child = child;
      }

    @Override
      public String getMessage() {
        StringWriter writer = new StringWriter();
        writer.append("Schemas ");
        writer.append(parent.toString());
        writer.append(" and ").append(child.toString()).append(" are incompatible because ");
        writer.append(super.getMessage());
        return writer.toString();
      }
  }
