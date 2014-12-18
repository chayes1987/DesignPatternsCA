import org.junit.Assert;
import org.junit.Test;
import strategy.Civilian;
import strategy.Hostage;
import template.Rescue;
import template.RescueCivilian;

/**
 * Created by Conor on 18/12/2014.
 */
public class TemplateMethodTest {
    @Test
    public void TestTemplateMethod(){
        Rescue rescueCivilian = new RescueCivilian(new Civilian());
        Assert.assertNotEquals(null, rescueCivilian);
        Rescue rescueHostage = new RescueCivilian(new Hostage());
        Assert.assertNotEquals(null, rescueHostage);
    }
}
