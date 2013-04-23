package org.apache.avro;

import java.io.StringWriter;

public class IncompatableSchemaException extends Exception {
      private Schema parent;
      private Schema child;

      public IncompatableSchemaException(String message, Schema parent, Schema child) {
          super(message);
          this.parent = parent;
          this.child = child;
      }

    public IncompatableSchemaException(String s) {
        super(s);
    }

    public IncompatableSchemaException(String s, Schema child) {
        super(s);
        this.child = child;
    }

    @Override
      public String getMessage() {
        if (parent == null && child == null)
            return super.getMessage();

          StringWriter writer = new StringWriter();
          if (parent != null) {
              writer.append("Schemas ");
              writer.append(parent.toString());
              writer.append(" and ").append(child.toString()).append(" are incompatible because ");
          } else {
              writer.append(child.toString()).append(": ");
          }
          writer.append(super.getMessage());
          return writer.toString();
      }
  }
