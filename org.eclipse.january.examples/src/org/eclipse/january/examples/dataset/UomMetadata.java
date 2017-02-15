package org.eclipse.january.examples.dataset;

import org.eclipse.january.metadata.MetadataType;
import org.unitsofmeasurement.unit.Unit;

public class UomMetadata implements MetadataType
{
  private final Unit<?> unit;

  public UomMetadata(Unit<?> unit)
  {
    this.unit = unit;
  }

  public UomMetadata clone()
  {
    return new UomMetadata(unit);
  }

  public Unit<?> getUnit()
  {
    return unit;
  }
}