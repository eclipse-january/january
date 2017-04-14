/*******************************************************************************
 * Copyright (c) 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - 
 *   Kasper Gammeltoft
 *******************************************************************************/
package org.eclipse.january.geometry.model.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.january.geometry.Geometry;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Shape;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Vertex;
import org.eclipse.january.geometry.model.services.STLGrammarAccess;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class STLSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private STLGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == GeometryPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case GeometryPackage.GEOMETRY:
				sequence_Geometry(context, (Geometry) semanticObject); 
				return; 
			case GeometryPackage.SHAPE:
				sequence_Shape_Impl(context, (Shape) semanticObject); 
				return; 
			case GeometryPackage.TRIANGLE:
				sequence_Triangle(context, (Triangle) semanticObject); 
				return; 
			case GeometryPackage.VERTEX:
				sequence_Vertex(context, (Vertex) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Geometry returns Geometry
	 *
	 * Constraint:
	 *     nodes+=Shape_Impl*
	 */
	protected void sequence_Geometry(ISerializationContext context, Geometry semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Shape_Impl returns Shape
	 *
	 * Constraint:
	 *     (name=EString? triangles+=Triangle*)
	 */
	protected void sequence_Shape_Impl(ISerializationContext context, Shape semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Triangle returns Triangle
	 *
	 * Constraint:
	 *     (normal=Vertex vertices+=Vertex*)
	 */
	protected void sequence_Triangle(ISerializationContext context, Triangle semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Vertex returns Vertex
	 *
	 * Constraint:
	 *     (x=DOUBLE y=DOUBLE z=DOUBLE)
	 */
	protected void sequence_Vertex(ISerializationContext context, Vertex semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GeometryPackage.Literals.VERTEX__X) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GeometryPackage.Literals.VERTEX__X));
			if (transientValues.isValueTransient(semanticObject, GeometryPackage.Literals.VERTEX__Y) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GeometryPackage.Literals.VERTEX__Y));
			if (transientValues.isValueTransient(semanticObject, GeometryPackage.Literals.VERTEX__Z) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GeometryPackage.Literals.VERTEX__Z));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVertexAccess().getXDOUBLETerminalRuleCall_1_0(), semanticObject.getX());
		feeder.accept(grammarAccess.getVertexAccess().getYDOUBLETerminalRuleCall_2_0(), semanticObject.getY());
		feeder.accept(grammarAccess.getVertexAccess().getZDOUBLETerminalRuleCall_3_0(), semanticObject.getZ());
		feeder.finish();
	}
	
	
}
