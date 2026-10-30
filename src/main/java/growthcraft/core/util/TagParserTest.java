package growthcraft.core.util;


import growthcraft.api.core.util.TagParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class TagParserTest
{
	@Test
	public void test_csv_parseToArray()
	{
		assertArrayEquals(new String[]{"1","2","3","4"}, TagParser.csv.parseToArray("1,2,3,4"));
		assertArrayEquals(new String[]{"1","2","3","4"}, TagParser.csv.parseToArray("     1,   2 ,   3,  4"));
	}

	@Test
	public void test_csv_parse()
	{
		final TagParser.Tag[] tags = TagParser.csv.parse("1,2,+3,-4");
		assertEquals(4, tags.length);
		assertEquals("1", tags[0].value);
		assertFalse(tags[0].exclude);
		assertFalse(tags[0].must);

		assertEquals("2", tags[1].value);
		assertFalse(tags[1].exclude);
		assertFalse(tags[1].must);

		assertEquals("3", tags[2].value);
		assertFalse(tags[2].exclude);
		assertTrue(tags[2].must);

		assertEquals("4", tags[3].value);
		assertTrue(tags[3].exclude);
		assertFalse(tags[3].must);
	}
}
