package org.eclipse.january.examples.dataset;

import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.uomo.units.SI;

public class UnitsOfMeasurementExample
{

  public static void main(String[] args)
  {
    Dataset dataset = DatasetFactory.createFromObject(new double[]
    {1, 2, 3, 4, 5, 6, 7, 8, 9});

    dataset.setMetadata(new UomMetadata(SI.NEWTON));
    
    System.out.println("res:" + dataset);
  }
}
