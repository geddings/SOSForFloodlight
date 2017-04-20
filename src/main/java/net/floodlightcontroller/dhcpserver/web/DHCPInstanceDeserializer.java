package net.floodlightcontroller.dhcpserver.web;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import net.floodlightcontroller.dhcpserver.DHCPInstance;

import java.io.IOException;

public class DHCPInstanceDeserializer extends JsonDeserializer<DHCPInstance> {

	@Override
	public DHCPInstance deserialize(JsonParser jParser, DeserializationContext dserCntx)
			throws IOException, JsonProcessingException {
		
		return null;
	}
}