package es.unileon.prg2.treegame;

import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import es.unileon.prg2.treegame.command.CommandCreateArticulationTest;
import es.unileon.prg2.treegame.command.CommandCreateExtremityTest;
import es.unileon.prg2.treegame.command.CommandCreateHalfLifeTest;
import es.unileon.prg2.treegame.command.CommandCreateSimpleShieldTest;
import es.unileon.prg2.treegame.command.CommandCreateSpecialShieldTest;
import es.unileon.prg2.treegame.command.CommandCreateStaticShieldTest;
import es.unileon.prg2.treegame.command.CommandCreateThresholdLifeTest;
import es.unileon.prg2.treegame.composite.ArticulationTest;
import es.unileon.prg2.treegame.composite.ExtremityTest;
import es.unileon.prg2.treegame.composite.shields.SimpleShieldTest;
import es.unileon.prg2.treegame.composite.shields.SpecialShieldTest;
import es.unileon.prg2.treegame.composite.shields.StaticShieldTest;
import es.unileon.prg2.treegame.handler.NodeHandlerTest;
import es.unileon.prg2.treegame.helpers.CreditTest;
import es.unileon.prg2.treegame.helpers.WeaponTest;
import es.unileon.prg2.treegame.strategy.DefaultLifeTest;
import es.unileon.prg2.treegame.strategy.HalfLifeTest;
import es.unileon.prg2.treegame.strategy.ThresholdLifeTest;

/**
 * Clase para hacer funcionar los tests.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ArticulationTest.class, ExtremityTest.class, 
	SimpleShieldTest.class, SpecialShieldTest.class, 
	StaticShieldTest.class,	NodeHandlerTest.class, 
	WeaponTest.class, DefaultLifeTest.class, 
	ThresholdLifeTest.class, HalfLifeTest.class, 
	CommandCreateArticulationTest.class, CommandCreateExtremityTest.class,
	CreditTest.class, CommandCreateHalfLifeTest.class, 
	CommandCreateSimpleShieldTest.class, CommandCreateSpecialShieldTest.class,
	CommandCreateStaticShieldTest.class, CommandCreateThresholdLifeTest.class,
	})

public class SuiteTests {
    @BeforeClass
    public static void setUp(){
        PropertyConfigurator.configure("./etc/log4j.properties");
    }
}
                     