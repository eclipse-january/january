package org.eclipse.january.examples.dataset;

import java.util.Arrays;

import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.IndexIterator;
import org.eclipse.january.dataset.LongDataset;
import org.eclipse.january.metadata.AxesMetadata;
import org.eclipse.january.metadata.internal.AxesMetadataImpl;
import org.eclipse.uomo.units.SI;
import org.unitsofmeasurement.unit.Unit;

public class AxesMetadataExample {

	public static void main(String[] args) {

		// configure Dataset A
		Dataset timestampsA = DatasetFactory.createFromList(Arrays.asList(100l,200l,300l));
		Dataset speedsA = DatasetFactory.createFromList(Arrays.asList(1d,2d,3d));		
		AxesMetadata axesMetadataA = new AxesMetadataImpl();
		axesMetadataA.initialize(1);
		axesMetadataA.setAxis(0, timestampsA);
		speedsA.addMetadata(axesMetadataA);
		speedsA.addMetadata(new UomMetadata(SI.METRES_PER_SECOND));
		
		printTimedDataset(speedsA);

		// configure Dataset B
		Dataset timestampsB = DatasetFactory.createFromList(Arrays.asList(100l,200l,300l));
		
		Dataset speedsB = DatasetFactory.createFromList(Arrays.asList(2d,4d,8d));
		AxesMetadata axesMetadataB = new AxesMetadataImpl();
		axesMetadataB.initialize(1);
		axesMetadataB.setAxis(0, timestampsB);
		speedsB.addMetadata(axesMetadataB);
		speedsB.addMetadata(new UomMetadata(SI.METRES_PER_SECOND));
		
		printTimedDataset(speedsB);
		
		// Add B to A
		Dataset sumAB = speedsA.iadd(speedsB);
		
		printTimedDataset(sumAB);
		
	}
	
	public static void printTimedDataset(Dataset dataset) {
		AxesMetadata axesMetadata = dataset.getFirstMetadata(AxesMetadata.class);
		LongDataset axisDataset = (LongDataset) axesMetadata.getAxes()[0];
		IndexIterator iterator = dataset.getIterator();
		UomMetadata uomMetadata = dataset.getFirstMetadata(UomMetadata.class);
		Unit<?> unit = uomMetadata.getUnit();
		while (iterator.hasNext()) {
			System.out.print(axisDataset.getLong(iterator.index) + " : " + dataset.getDouble(iterator.index) + unit.toString());
			if (iterator.index < dataset.getSize() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
}
