/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apache.river.container.admin.app;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author trasukg
 */
public class CommandLineParserTest {
    
    @Test
    public void testParser() throws Exception  {
        Options options=new Options();
        Option profile= OptionBuilder.hasArg()
                .withDescription("Profile name to apply this command to").create("p");
        options.addOption(profile);
        
        String[] args=new String[]{  "list", "-p","admin"};
        
        CommandLineParser parser=new PosixParser();
        CommandLine cmd=parser.parse(options, args);
        assertTrue(cmd.hasOption("p"));
        assertEquals("Profile value", "admin", cmd.getOptionValue("p"));
        
        String[] remainingArgs=cmd.getArgs();
        assertEquals("number of remaining arguments", 1, remainingArgs.length);
        assertEquals("Remaining arg", "list", remainingArgs[0]);
        
    }
}
