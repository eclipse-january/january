package org.eclipse.january.examples.dataset;

import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.metadata.MetadataType;
import org.eclipse.uomo.units.SI;
import org.unitsofmeasurement.unit.Unit;

public class UnitsOfMeasurementExample
{

  public static class UomMetadata implements MetadataType
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

  public static void main(String[] args)
  {
    Dataset dataset = DatasetFactory.createFromObject(new double[]
    {1, 2, 3, 4, 5, 6, 7, 8, 9});

    dataset.setMetadata(new UomMetadata(SI.NEWTON));
    
    System.out.println("res:" + dataset);
  }
}
