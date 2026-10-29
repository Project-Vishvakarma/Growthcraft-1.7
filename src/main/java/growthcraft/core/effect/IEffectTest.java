package growthcraft.core.effect;

public class IEffectTest
{
	@Test
	public void test_apply()
	{
		final TestEffect eff = new TestEffect();
		eff.apply(null, null, null, null);
		assertEquals(eff.touched, 1);
	}
}
