package net.sourceforge.docfetcher.gui;

import java.awt.GridLayout;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import net.sourceforge.docfetcher.enums.Img;
import net.sourceforge.docfetcher.enums.Msg;

//To create more than one search tabs and perform multiple searches 
public class CreateSearchTabs {

	  //CTabFolder - keep track of the tab index
	  private int insertMark = -1;
	  private static  CTabFolder tabFolder;
	  
	  
	  public CreateSearchTabs(Shell shell) {
		  //Initialize To create tabfolder 
		  tabFolder = new CTabFolder(shell, SWT.TOP | SWT.CLOSE);
		  tabFolder.setBorderVisible(true);
		  tabFolder.setLayoutData(new GridData(GridData.FILL_BOTH));
		  tabFolder.setUnselectedCloseVisible(false);
	}

	public CTabItem createTabItem() {
		  //create new tab item
		  CTabItem cbt = new CTabItem(tabFolder, SWT.NONE);
		  cbt.setImage(Img.WINDOW.get());
		  cbt.setText(Msg.searchTab_msg.get()+"("
   	            + (insertMark + 1) + ")");
     	 	insertMark = insertMark + 1;
     	 return cbt;
	  }
	  
	  public SashForm createSashForm() {
		  //create new sash form for each new tab item created
		  	SashForm sashForm = new SashForm(tabFolder, SWT.VERTICAL);
		  	sashForm.setLayout(new FillLayout());
		    return sashForm;
			
	      }
	  public void setSashForm(CTabItem cbt,SashForm sashForm)
	  {
		  //assign the tab with sash form (which has the search form)
		  cbt.setControl(sashForm);
	  }
}