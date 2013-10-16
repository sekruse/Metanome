package de.uni_potsdam.hpi.metanome.algorithm_integration.configuration;

import de.uni_potsdam.hpi.metanome.algorithm_integration.Algorithm;

/**
 * Represents csv file configuration values for {@link Algorithm}s.
 */
public class ConfigurationValueCsvFile implements ConfigurationValue {

	protected final String identifier;
	protected final CsvFileConfiguration value;
	
	/**
	 * Constructs a ConfigurationValueBoolean using the specification's identifier and the boolean value.
	 * 
	 * @param identifier
	 * @param value
	 */
	public ConfigurationValueCsvFile(String identifier, CsvFileConfiguration value) {
		this.identifier = identifier;
		this.value = value;
	}
	
	/**
	 * Sets it's own value on the algorithm (second call of double dispatch).
	 * 
	 * @param algorithm
	 */
	@Override
	public void triggerSetValue(Algorithm algorithm) {
		algorithm.setConfigurationValue(identifier, value);		
	}

}