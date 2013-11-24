package de.uni_potsdam.hpi.metanome.frontend.client.tabs;

import java.util.List;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockPanel;

import de.uni_potsdam.hpi.metanome.frontend.client.services.ExecutionServiceAsync;

public class ResultsTab extends DockPanel {
	
	protected ExecutionServiceAsync executionService;
	
	protected Timer timer;
	protected String algorithmName;

	public ResultsTab(ExecutionServiceAsync executionService, String algorithmName) {
		this.executionService = executionService;
		this.algorithmName = algorithmName;
		//TODO add UI elements
	}

	public void startPolling() {
		this.timer = new Timer() {
	      public void run() {		    	  
	    	  fetchNewResults();
	      }
	    };

	    this.timer.scheduleRepeating(200);
	}
	
	public AsyncCallback<Void> getCancelCallback() {
		AsyncCallback<Void> callback = new AsyncCallback<Void>() {
		      public void onFailure(Throwable caught) {
		    	  // TODO: Do something with errors.
				  cancelTimer();
		      }

		      public void onSuccess(Void v) {  	
				  cancelTimer();
		      }
		};
		return callback;
	}
	
	public void cancelTimer(){
		this.timer.cancel();
		fetchNewResults();
	}

	protected void fetchNewResults() {
		executionService.fetchNewResults(algorithmName, new AsyncCallback<List<String>>() {
			  
			  @Override
			  public void onFailure(Throwable caught) {
				  // TODO Auto-generated method stub
			  }
			  
			  @Override
			  public void onSuccess(List<String> result) {
				  // TODO Auto-generated method stub
				  System.out.println("Successfully fetched results:");
				  for (String s : result) {
					  System.out.println(s);
				  }
			  }
		  });
	}
}
