package be.seeseemelk.mockbukkit.entity;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LivingEntityMockTest
{

	private ServerMock server;
	private CowMock livingEntity;

	@BeforeEach
	void setup()
	{
		server = MockBukkit.mock();
		livingEntity = new CowMock(server, UUID.randomUUID());
	}

	@AfterEach
	void tearDown()
	{
		MockBukkit.unmock();
	}

	@Test
	void testGetKillerDefault()
	{
		assertNull(livingEntity.getKiller());
	}

	@Test
	void testSetKiller()
	{
		PlayerMock player = server.addPlayer();

		livingEntity.setKiller(player);
		assertEquals(player, livingEntity.getKiller());
	}

	@Test
	void testSetKillerNullDoesNotThrow()
	{
		livingEntity.setKiller(null);
		assertNull(livingEntity.getKiller());
	}

}