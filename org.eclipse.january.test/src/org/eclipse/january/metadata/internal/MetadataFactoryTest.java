/*******************************************************************************
 * Copyright (c) 2016 Diamond Light Source Ltd. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Diamond Light Source Ltd - initial API and implementation
 *******************************************************************************/
package org.eclipse.january.metadata.internal;

import static org.eclipse.january.asserts.TestUtils.assertDatasetEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.measure.Dimension;
import javax.measure.IncommensurableException;
import javax.measure.Quantity;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.quantity.Time;

import org.eclipse.january.MetadataException;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.LazyDatasetBase;
import org.eclipse.january.metadata.AxesMetadata;
import org.eclipse.january.metadata.DimensionMetadata;
import org.eclipse.january.metadata.DynamicConnectionInfo;
import org.eclipse.january.metadata.ErrorMetadata;
import org.eclipse.january.metadata.IExtendedMetadata;
import org.eclipse.january.metadata.IMetadata;
import org.eclipse.january.metadata.MaskMetadata;
import org.eclipse.january.metadata.MetadataFactory;
import org.eclipse.january.metadata.MetadataType;
import org.eclipse.january.metadata.OriginMetadata;
import org.eclipse.january.metadata.PeemMetadata;
import org.eclipse.january.metadata.StatisticsMetadata;
import org.eclipse.january.metadata.UnitMetadata;
import org.junit.Test;

public class MetadataFactoryTest {

	@Test
	public void testFinder() throws MetadataException {
		Class<? extends MetadataType> clazz = LazyDatasetBase.findMetadataTypeSubInterfaces(IExtendedMetadata.class);
		assertEquals(IExtendedMetadata.class, clazz);

		clazz = LazyDatasetBase.findMetadataTypeSubInterfaces(DynamicConnectionInfo.class);
		assertEquals(DynamicConnectionInfo.class, clazz);

		// this interface is a sub-interface of DimensionMetadata
		clazz = LazyDatasetBase.findMetadataTypeSubInterfaces(OriginMetadataImpl.class);
		assertEquals(OriginMetadata.class, clazz);

		// test for anonymous class
		clazz = LazyDatasetBase.findMetadataTypeSubInterfaces(new DynamicConnectionInfo() {
			private static final long serialVersionUID = 3467617639382611191L;
			
		}.getClass());
		assertEquals(DynamicConnectionInfo.class, clazz);

		// test for inner class
		clazz = LazyDatasetBase.findMetadataTypeSubInterfaces(new InnerMetadata().getClass());
		assertEquals(InnerMetadata.class, clazz);

		// test for inner class
		clazz = LazyDatasetBase.findMetadataTypeSubInterfaces(new InnerMetadata2().getClass());
		assertEquals(InnerMetadata2.class, clazz);
	}

	class InnerMetadata implements MetadataType {
		private static final long serialVersionUID = 93680612340323601L;

		public InnerMetadata() {
		}

		@Override
		public InnerMetadata clone() {
			return new InnerMetadata();
		}
	}

	static class InnerMetadata2 implements MetadataType {
		private static final long serialVersionUID = 93680612340323601L;

		public InnerMetadata2() {
		}

		@Override
		public InnerMetadata2 clone() {
			return new InnerMetadata2();
		}
	}

	@Test
	public void testFinderWithInproperMetadataType() {
		try {
			LazyDatasetBase.findMetadataTypeSubInterfaces(MetadataType.class);
			fail("Should not be able to find direct implementation of MetadataType");
		} catch (IllegalArgumentException e) {
		}

		MetadataType md = new MetadataType() {
			private static final long serialVersionUID = 1L;

			@Override
			public MetadataType clone() {
				return null;
			}
		};

		try {
			LazyDatasetBase.findMetadataTypeSubInterfaces(md.getClass());
			fail("Should not be able to find anonymous direct implementation of MetadataType");
		} catch (IllegalArgumentException e) {
		}

		Dataset d = DatasetFactory.zeros(2, 3);
		try {
			d.addMetadata(md);
			fail("Should not be able to add anonymous direct implementation of MetadataType");
		} catch (IllegalArgumentException e) {
			
		}
	}

	@Test
	public void testCreator() throws MetadataException {
		ErrorMetadata emd = MetadataFactory.createMetadata(ErrorMetadata.class);
		assertEquals(new ErrorMetadataImpl().getError(), emd.getError());
	}

	@Test
	public void testMetadata() throws MetadataException {
		Map<String, Serializable> meta = new HashMap<>();
		meta.put("Hello", "World");
		IMetadata imd = MetadataFactory.createMetadata(IMetadata.class, meta);

		assertEquals(meta.get("Hello"), imd.clone().getMetaValue("Hello"));
	}

	static class TimeUnit implements Unit<Time>, Serializable {
		private static final long serialVersionUID = 4921003883507361264L;

		@Override
		public String getSymbol() {
			return "AE";
		}

		@Override
		public String getName() {
			return "aeon";
		}

		@Override
		public Dimension getDimension() {
			return null;
		}

		@Override
		public Unit<Time> getSystemUnit() {
			return null;
		}

		@Override
		public Map<? extends Unit<?>, Integer> getBaseUnits() {
			return null;
		}

		@Override
		public boolean isCompatible(Unit<?> that) {
			return false;
		}

		@Override
		public <T extends Quantity<T>> Unit<T> asType(Class<T> type) throws ClassCastException {
			return null;
		}

		@Override
		public UnitConverter getConverterTo(Unit<Time> that) throws UnconvertibleException {
			return null;
		}

		@Override
		public UnitConverter getConverterToAny(Unit<?> that) throws IncommensurableException, UnconvertibleException {
			return null;
		}

		@Override
		public Unit<Time> alternate(String symbol) {
			return null;
		}

		@Override
		public Unit<Time> shift(double offset) {
			return null;
		}

		@Override
		public Unit<Time> multiply(double multiplier) {
			return null;
		}

		@Override
		public Unit<?> multiply(Unit<?> multiplier) {
			return null;
		}

		@Override
		public Unit<?> inverse() {
			return null;
		}

		@Override
		public Unit<Time> divide(double divisor) {
			return null;
		}

		@Override
		public Unit<?> divide(Unit<?> divisor) {
			return null;
		}

		@Override
		public Unit<?> root(int n) {
			return null;
		}

		@Override
		public Unit<?> pow(int n) {
			return null;
		}

		@Override
		public Unit<Time> transform(UnitConverter operation) {
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	static final Class[] types = new Class[] {
		IMetadata.class, ErrorMetadata.class, AxesMetadata.class, DimensionMetadata.class,
		MaskMetadata.class, OriginMetadata.class, PeemMetadata.class, StatisticsMetadata.class,
		UnitMetadata.class
	};

	static final Object[][] arguments = new Object[][] {
		new Object[] { new HashMap<String, Serializable>() },
		new Object[] { DatasetFactory.ones(2, 3) },
		new Object[] { 4 },
		new Object[] { new int[] {2, 256}, new int[] {-1, 256}, new int[] {1, 64} },
		new Object[] { DatasetFactory.ones(3, 2) },
		new Object[] { null , null, new int[] {1,2}, "/file/path", "/data/path" },
		new Object[] { new double[] {-3, 2.5}, 1.25, 3.14 },
		new Object[] { DatasetFactory.createRange(12) },
		new Object[] { new TimeUnit() },
		};

	@SuppressWarnings("unchecked")
	@Test
	public void testAllCreators() throws MetadataException, ClassNotFoundException, IOException {
		int n = types.length;
		for (int i = 0; i < n; i++) {
			Class<? extends MetadataType> mc = types[i];
			Object[] params = arguments[i];
			MetadataType md = MetadataFactory.createMetadata(mc, params);

			Object exp = null;
			Object act = null;
			switch (i) {
			case 0:
				IMetadata m0 = (IMetadata) md;
				exp = 0;
				act = m0.getMetaNames().size();
				break;
			case 1:
				ErrorMetadata m1 = (ErrorMetadata) md;
				exp = params[0];
				act = m1.getError();
				break;
			case 2:
				AxesMetadata m2 = (AxesMetadata) md;
				exp = params[0];
				act = m2.getAxes().length;
				break;
			case 3:
				DimensionMetadata m3 = (DimensionMetadata) md;
				exp = params[2];
				act = m3.getDataChunkDimensions();
				break;
			case 4:
				MaskMetadata m4 = (MaskMetadata) md;
				exp = ((Dataset) params[0]).getShape();
				act = m4.getMask().getShape();
				break;
			case 5:
				OriginMetadata m5 = (OriginMetadata) md;
				exp = params[3];
				act = m5.getFilePath();
				break;
			case 6:
				PeemMetadata m6 = (PeemMetadata) md;
				exp = params[1];
				act = m6.getScaling();
				break;
			case 7:
				StatisticsMetadata<Double> m7 = (StatisticsMetadata<Double>) md;
				exp = ((Dataset) params[0]).min(true);
				act = m7.getMinimum(true);
				break;
			case 8:
				UnitMetadata m8 = (UnitMetadata) md;
				exp = ((TimeUnit) params[0]).getName();
				act = m8.getUnit().getName();
				break;
			}

			assertTrue(Objects.deepEquals(exp, act));

			checkSerializable(md);
		}
	}

	private void checkSerializable(MetadataType md) throws IOException, ClassNotFoundException, MetadataException {
		Dataset a = DatasetFactory.createRange(12);
		a.setShape(3,4);
		a.addMetadata(md);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream ostream = new ObjectOutputStream(out);
		ostream.writeObject(a);
		ostream.close();
		byte[] bytes = out.toByteArray();
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		ObjectInputStream istream = new ObjectInputStream(in);
		Dataset b = Dataset.class.cast(istream.readObject());

		assertDatasetEquals(a, b);
	}
}
