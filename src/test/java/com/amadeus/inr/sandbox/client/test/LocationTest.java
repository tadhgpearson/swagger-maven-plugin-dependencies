/**
 * 
 */
package com.amadeus.inr.sandbox.client.test;

import static org.junit.Assert.*;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.AffiliateSearchResponse;
import io.swagger.client.model.AffiliateSearchResult;
import io.swagger.client.model.AirportInformation;
import io.swagger.client.model.CityInformation;
import io.swagger.client.model.FlightSearchSegment;
import io.swagger.client.model.LocationResponse;

/**
 * @author tpearson
 *
 */
public class LocationTest {
	
	private static final String APIKEY = System.getenv("apikey");
	private static final DefaultApi API = new DefaultApi();



	@Test
	public void testSimpleCitySearch() throws ApiException{
		String location = "DUB";
		LocationResponse searchRS = API.locationInformation(APIKEY, location);
		
		CityInformation city = searchRS.getCity();
		assertEquals(location, city.getCode());
		assertEquals("IE", city.getCountry());
		assertEquals("EUR", city.getCurrency());
		assertEquals("2964574", city.getGeonamesID());
		assertEquals("Europe/Dublin", city.getTimezone());
		
		List<AirportInformation> airports = searchRS.getAirports();
		assertEquals(1, airports.size());
		
		AirportInformation airport = airports.get(0);
		assertEquals(location, airport.getCode());
		assertEquals(city.getCode(), airport.getCityCode());
		assertEquals(city.getName(), airport.getCityName());
		assertEquals("IE", city.getCountry());
		assertEquals("EUR", city.getCurrency());
		assertEquals("Europe/Dublin", city.getTimezone());
	}
}
