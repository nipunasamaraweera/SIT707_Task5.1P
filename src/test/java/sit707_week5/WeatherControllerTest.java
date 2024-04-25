package sit707_week5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class WeatherControllerTest {

    private WeatherController wController;
    private double[] hourlyTemperatures;
    private double minTemperature;
    private double maxTemperature;
    private double averageTemperature;

    @Before
    public void setUp() {
        // Arrange: Initialize the controller
        wController = WeatherController.getInstance();

        // Retrieve hourly temperatures and calculate min, max, and average
        int nHours = wController.getTotalHours();
        hourlyTemperatures = new double[nHours];
        double sumTemp = 0;
        minTemperature = Double.MAX_VALUE;
        maxTemperature = Double.MIN_VALUE;

        for (int i = 0; i < nHours; i++) {
            // Retrieve temperature for each hour
            double temperatureVal = wController.getTemperatureForHour(i + 1);
            hourlyTemperatures[i] = temperatureVal;
            sumTemp += temperatureVal;

            // Update min and max temperatures
            if (temperatureVal < minTemperature) {
                minTemperature = temperatureVal;
            }
            if (temperatureVal > maxTemperature) {
                maxTemperature = temperatureVal;
            }
        }

        // Calculate average temperature
        averageTemperature = sumTemp / nHours;
    }

    @After
    public void tearDown() {
        // No need to close the controller here to preserve cached functions' state
    }

    @Test
	public void testStudentIdentity() {
		String studentId = "223131384";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Nipuna Samaraweera";
		Assert.assertNotNull("Student name is null", studentName);
	}

    @Test
    public void testTemperatureMin() {
        // Arrange
        
        // Act: Get the minimum temperature from cache
        double cachedMinTemperature = wController.getTemperatureMinFromCache();

        // Assert: Check that the cached minimum matches the calculated minimum temperature
        Assert.assertEquals(minTemperature, cachedMinTemperature, 0.001);
    }

    @Test
    public void testTemperatureMax() {
        // Arrange
        
        // Act: Get the maximum temperature from cache
        double cachedMaxTemperature = wController.getTemperatureMaxFromCache();

        // Assert: Check that the cached maximum matches the calculated maximum temperature
        Assert.assertEquals(maxTemperature, cachedMaxTemperature, 0.001);
    }

    @Test
    public void testTemperatureAverage() {
        // Arrange
        
        // Act: Get the average temperature from cache
        double cachedAverageTemperature = wController.getTemperatureAverageFromCache();

        // Assert: Check that the cached average matches the calculated average temperature
        Assert.assertEquals(averageTemperature, cachedAverageTemperature, 0.001);
    }

    @Test
    public void testTemperaturePersist() {
    	/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}

}
