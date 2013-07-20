package net.sf.anathema.platform.tree.display.transform;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AgnosticTransform implements Iterable<TransformOperation> {

  private List<TransformOperation> operations = new ArrayList<>();

  public void add(TransformOperation operation) {
    operations.add(operation);
  }

  @Override
  public Iterator<TransformOperation> iterator() {
    return operations.iterator();
  }

  public void setToIdentity() {
    operations.clear();
  }

  public AgnosticTransform createCopy() {
    AgnosticTransform copy = new AgnosticTransform();
    for (TransformOperation operation : operations) {
      copy.add(operation);
    }
    return copy;
  }


  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public int hashCode() {
    return operations.hashCode();
  }
}