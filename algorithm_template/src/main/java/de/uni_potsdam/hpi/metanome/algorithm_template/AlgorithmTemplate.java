package de.uni_potsdam.hpi.metanome.algorithm_template;

import java.util.List;

import de.uni_potsdam.hpi.metanome.algorithm_integration.FunctionalDependencyAlgorithm;
import de.uni_potsdam.hpi.metanome.algorithm_integration.UniqueColumnCombinationsAlgorithm;
import de.uni_potsdam.hpi.metanome.algorithm_integration.configuration.ConfigurationSpecification;
import de.uni_potsdam.hpi.metanome.algorithm_integration.input.SimpleRelationalInputGenerator;
import de.uni_potsdam.hpi.metanome.algorithm_integration.result_receiver.FunctionalDependencyResultReceiver;
import de.uni_potsdam.hpi.metanome.algorithm_integration.result_receiver.UniqueColumnCombinationResultReceiver;

public class AlgorithmTemplate implements UniqueColumnCombinationsAlgorithm, FunctionalDependencyAlgorithm {

	public List<ConfigurationSpecification> getConfigurationRequirements() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setConfigurationValue(String identifier, String value) {
		// TODO Auto-generated method stub
		
	}

	public void setConfigurationValue(String identifier, boolean value) {
		// TODO Auto-generated method stub
		
	}

	public void setConfigurationValue(String identifier,
			SimpleRelationalInputGenerator value) {
		// TODO Auto-generated method stub
		
	}

	public void execute() {
		// TODO Auto-generated method stub
		
	}

	public void setResultReceiver(
			FunctionalDependencyResultReceiver resultReceiver) {
		// TODO Auto-generated method stub
		
	}

	public void setResultReceiver(
			UniqueColumnCombinationResultReceiver resultReceiver) {
		// TODO Auto-generated method stub
		
	}
	
}