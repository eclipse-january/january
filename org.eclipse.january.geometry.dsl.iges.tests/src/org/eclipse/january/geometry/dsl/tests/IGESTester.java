package org.eclipse.january.geometry.dsl.tests;

import static org.junit.Assert.*;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.january.geometry.dsl.IGESStandaloneSetup;
import org.eclipse.january.geometry.dsl.iGES.*;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Injector;

public class IGESTester {
	
	private boolean testWikiIGES = false;
	private boolean printout = false;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		long time = System.currentTimeMillis();
		Path path = FileSystems.getDefault().getPath("src", "org", "eclipse", "january", "geometry", "xtext",
				"tests", "resources", "test1.igs");
		Injector injector = new IGESStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSet.getResource(URI.createFileURI(path.toFile().getAbsolutePath()), true);

		IGES data = (IGES) resource.getContents().get(0);
		System.out.println("Took " + ((System.currentTimeMillis()-time)/1000.0) + "seconds to load file.");
		if (printout) {
			System.out.println(data.getStart());
			
			List<Value> values = data.getGlobal().getValues();
			
			for(Value v: values) {
				if (v instanceof HString) {
					System.out.print(((HString)v).getVal()+",");
				}else if (v instanceof Pointer) {
					System.out.print(((Pointer)v).getVal()+",");
				} else {
					System.out.print(((Param)v).getVal()+",");
				}
			}
			System.out.println();
			
			List<Entry> entries = data.getData().getEntries();
			for(Entry e: entries) {
				System.out.println(e.getType()+" "+e.getParamData()+" "+e.getStructure()+" "+e.getLineFont()+" "+e.getLevel()+" "+e.getView()+" "+e.getTransformMatrix()+" 0 "+e.getStatus()+" "+e.getIndex()+"\n"
							+e.getType()+" "+e.getLineWeight()+" "+e.getColor()+" "+e.getParamLines()+" "+e.getForm()+" "+e.getSubNum()+" ");
			}
			
			List<PEntry> parameters = data.getParameters().getEntries();
			for(PEntry e: parameters) {
				System.out.print(e.getType()+",");
				for(Value v: e.getValues()) {
					if (v instanceof Pointer) {
						System.out.print(((Pointer)v).getVal()+",");
					} else {
						System.out.print(((Param)v).getVal()+",");
					}
				}
				System.out.println("    P "+e.getIndicies().get(0));
			}
			System.out.println(data.getEnd());
		}
		
		if (testWikiIGES) {
			testIGES(data);
		}
	}
	
	private void testIGES(IGES data) {
		Start s = data.getStart();
		assertEquals(1, s.getLines().size());
		
		String sl = s.getLines().get(0);
		assertEquals("                                                                        S      1\n", sl);
		
		Global g = data.getGlobal();
		
		List<Value> gv = g.getValues();
	    assertEquals(23, gv.size());
	    
	    assertEquals("1H;", ((HString)gv.get(0)).getVal());
	    assertEquals("4HSLOT", ((HString)gv.get(1)).getVal());
	    assertEquals("37H$1$DUA2:[IGESLIB.BDRAFT.B2I]SLOT.IGS;", ((HString)gv.get(2)).getVal());
	    assertEquals("17HBravo3 BravoDRAFT", ((HString)gv.get(3)).getVal());
	    assertEquals("31HBravo3->IGES V3.002 (02-Oct-87)", ((HString)gv.get(4)).getVal());
	    assertEquals(32, ((Pointer)gv.get(5)).getVal());
	    assertEquals(38, ((Pointer)gv.get(6)).getVal());
	    assertEquals(6, ((Pointer)gv.get(7)).getVal());
	    assertEquals(38, ((Pointer)gv.get(8)).getVal());
	    assertEquals(15, ((Pointer)gv.get(9)).getVal());
	    assertEquals("4HSLOT", ((HString)gv.get(10)).getVal());
	    assertEquals(1.0, ((Param)gv.get(11)).getVal(), 0.0);
	    assertEquals(1, ((Pointer)gv.get(12)).getVal());
        // ...
	    // If all those are correct, check last values and move on
	    
	    assertEquals("24HAPPLICON - Ann Arbor, MI", ((HString)gv.get(20)).getVal());
	    assertEquals(4, ((Pointer)gv.get(21)).getVal());
	    assertEquals(0, ((Pointer)gv.get(22)).getVal());
	    
	    
	    Data d = data.getData();
	    
	    List<Entry> de = d.getEntries();
	    
	    assertEquals(6, de.size());

	    checkEntry(de.get(0), 116, 1, 0, 1, 0, 0, 0, 1, 1, 1, 5, 1, 0, null, 0);
	    checkEntry(de.get(1), 116, 2, 0, 1, 0, 0, 0, 1, 3, 1, 5, 1, 0, null, 0);
	    checkEntry(de.get(2), 100, 3, 0, 1, 0, 0, 0, 1, 5, 1, 2, 1, 0, null, 0);
	    checkEntry(de.get(3), 100, 4, 0, 1, 0, 0, 0, 1, 7, 1, 2, 1, 0, null, 0);
	    checkEntry(de.get(4), 110, 5, 0, 1, 0, 0, 0, 1, 9, 1, 3, 1, 0, null, 0);
	    checkEntry(de.get(5), 110, 6, 0, 1, 0, 0, 0, 1, 11, 1, 3, 1, 0, null, 0);
	    
	    Parameters p = data.getParameters();
	    
	    List<PEntry> pe = p.getEntries();
	    
	    assertEquals(6, pe.size());
	    
	    PEntry p1 = pe.get(0);
	    assertEquals(116, p1.getType());
	    
	    List<Value> p1v = p1.getValues();
	    assertEquals(6, p1v.size());
	    
	    assertEquals(0.0, ((Param)p1v.get(0)).getVal(), 0.0);
	    assertEquals(0.0, ((Param)p1v.get(1)).getVal(), 0.0);
	    assertEquals(0.0, ((Param)p1v.get(2)).getVal(), 0.0);
	    assertEquals(0, ((Pointer)p1v.get(3)).getVal());
	    assertEquals(0, ((Pointer)p1v.get(4)).getVal());
	    assertEquals(0, ((Pointer)p1v.get(5)).getVal());
	    
	    PEntry p2 = pe.get(1);
	    assertEquals(116, p2.getType());
	    
	    List<Value> p2v = p2.getValues();
	    assertEquals(6, p2v.size());
	    
	    assertEquals(5.0, ((Param)p2v.get(0)).getVal(), 0.0);
	    assertEquals(0.0, ((Param)p2v.get(1)).getVal(), 0.0);
	    assertEquals(0.0, ((Param)p2v.get(2)).getVal(), 0.0);
	    assertEquals(0, ((Pointer)p2v.get(3)).getVal());
	    assertEquals(0, ((Pointer)p2v.get(4)).getVal());
	    assertEquals(0, ((Pointer)p2v.get(5)).getVal());
	    
	    PEntry p3 = pe.get(2);
	    assertEquals(100, p3.getType());
	    
	    List<Value> p3v = p3.getValues();
	    assertEquals(9, p3v.size());
	    
	    assertEquals(0.0, ((Param)p3v.get(0)).getVal(), 0.0);
	    assertEquals(0.0, ((Param)p3v.get(1)).getVal(), 0.0);
	    assertEquals(0.0, ((Param)p3v.get(2)).getVal(), 0.0);
	    assertEquals(0.0, ((Param)p3v.get(3)).getVal(), 0.0);
	    assertEquals(1.0, ((Param)p3v.get(4)).getVal(), 0.0);
	    assertEquals(0.0, ((Param)p3v.get(5)).getVal(), 0.0);
	    assertEquals(-1.0, ((Param)p3v.get(6)).getVal(), 0.0);
	    assertEquals(0, ((Pointer)p3v.get(7)).getVal());
	    assertEquals(0, ((Pointer)p3v.get(8)).getVal());
	    
	    PEntry p4 = pe.get(3);
	    assertEquals(100, p4.getType());
	    
	    List<Value> p4v = p4.getValues();
	    assertEquals(9, p4v.size());
	    
	    assertEquals(0.0, ((Param)p4v.get(0)).getVal(), 0.0);
	    assertEquals(5.0, ((Param)p4v.get(1)).getVal(), 0.0);
	    assertEquals(0.0, ((Param)p4v.get(2)).getVal(), 0.0);
	    assertEquals(5.0, ((Param)p4v.get(3)).getVal(), 0.0);
	    assertEquals(-1.0, ((Param)p4v.get(4)).getVal(), 0.0);
	    assertEquals(5.0, ((Param)p4v.get(5)).getVal(), 0.0);
	    assertEquals(1.0, ((Param)p4v.get(6)).getVal(), 0.0);
	    assertEquals(0, ((Pointer)p4v.get(7)).getVal());
	    assertEquals(0, ((Pointer)p4v.get(8)).getVal());
	    
	    PEntry p5 = pe.get(4);
	    assertEquals(110, p5.getType());
	    
	    List<Value> p5v = p5.getValues();
	    assertEquals(8, p5v.size());
	    
	    assertEquals(0.0, ((Param)p5v.get(0)).getVal(), 0.0);
	    assertEquals(-1.0, ((Param)p5v.get(1)).getVal(), 0.0);
	    assertEquals(0.0, ((Param)p5v.get(2)).getVal(), 0.0);
	    assertEquals(5.0, ((Param)p5v.get(3)).getVal(), 0.0);
	    assertEquals(-1.0, ((Param)p5v.get(4)).getVal(), 0.0);
	    assertEquals(0.0, ((Param)p5v.get(5)).getVal(), 0.0);
	    assertEquals(0, ((Pointer)p5v.get(6)).getVal());
	    assertEquals(0, ((Pointer)p5v.get(7)).getVal());
	    
	    PEntry p6 = pe.get(5);
	    assertEquals(110, p6.getType());
	    
	    List<Value> p6v = p6.getValues();
	    assertEquals(8, p6v.size());
	    
	    assertEquals(0.0, ((Param)p6v.get(0)).getVal(), 0.0);
	    assertEquals(1.0, ((Param)p6v.get(1)).getVal(), 0.0);
	    assertEquals(0.0, ((Param)p6v.get(2)).getVal(), 0.0);
	    assertEquals(5.0, ((Param)p6v.get(3)).getVal(), 0.0);
	    assertEquals(1.0, ((Param)p6v.get(4)).getVal(), 0.0);
	    assertEquals(0.0, ((Param)p6v.get(5)).getVal(), 0.0);
	    assertEquals(0, ((Pointer)p6v.get(6)).getVal());
	    assertEquals(0, ((Pointer)p6v.get(7)).getVal());

	    End e = data.getEnd();
	    
	    assertEquals(1,  e.getSval());
	    assertEquals(4, e.getGval());
	    assertEquals(12, e.getDval());
	    assertEquals(6, e.getPval());
	    assertEquals(1, e.getTval());
	}
	
	private void checkEntry(Entry entry, int type, int param, int struct, int linefont, 
			int level, int view, int matrix, int statNum, int index, int lineweight, 
			int color, int paramlines, int form, String label, int subNum) {
		assertEquals(type, entry.getType());
		assertEquals(param, entry.getParamData());
		assertEquals(struct, entry.getStructure());
		assertEquals(linefont, entry.getLineFont());
		assertEquals(level, entry.getLevel());
		assertEquals(view, entry.getView());
		assertEquals(matrix, entry.getTransformMatrix());
		assertEquals(statNum, entry.getStatus());
		assertEquals(index, entry.getIndex());
		assertEquals(lineweight, entry.getLineWeight());
		assertEquals(color, entry.getColor());
		assertEquals(paramlines, entry.getParamLines());
		assertEquals(form, entry.getForm());
		assertEquals(label, entry.getEntityLabel());
		assertEquals(subNum, entry.getSubNum());
	}
	
}
