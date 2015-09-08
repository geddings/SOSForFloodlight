package net.floodlightcontroller.sos;

import org.projectfloodlight.openflow.types.IPv4Address;
import org.projectfloodlight.openflow.types.TransportPort;

public class SOSWhitelistEntry {
	private IPv4Address serverIp;
	private IPv4Address clientIp;
	private TransportPort serverPort;
	
	private SOSWhitelistEntry(IPv4Address serverIp, TransportPort serverPort, IPv4Address clientIp) {
		this.serverIp = serverIp;
		this.serverPort = serverPort;
		this.clientIp = clientIp;
	}
	
	public static SOSWhitelistEntry of(IPv4Address serverIp, TransportPort serverPort, IPv4Address clientIp) {
		if (serverIp == null || serverIp.equals(IPv4Address.NONE)) {
			throw new IllegalArgumentException("Server IP must be a valid IP. Was " + serverIp == null ? "null" : serverIp.toString());
		}
		if (serverPort == null || serverPort.equals(TransportPort.NONE)) {
			throw new IllegalArgumentException("Server port must be a valid port. Was " + serverPort == null ? "null" : serverPort.toString());
		}
		if (clientIp == null || clientIp.equals(IPv4Address.NONE)) {
			throw new IllegalArgumentException("Client IP must be a valid IP. Was " + clientIp == null ? "null" : clientIp.toString());
		}
		
		return new SOSWhitelistEntry(serverIp, serverPort, clientIp);
	}
	
	public IPv4Address getServerIP() {
		return serverIp;
	}
	
	public TransportPort getServerPort() {
		return serverPort;
	}
	
	public IPv4Address getClientIP() {
		return clientIp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clientIp == null) ? 0 : clientIp.hashCode());
		result = prime * result
				+ ((serverIp == null) ? 0 : serverIp.hashCode());
		result = prime * result
				+ ((serverPort == null) ? 0 : serverPort.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SOSWhitelistEntry other = (SOSWhitelistEntry) obj;
		if (clientIp == null) {
			if (other.clientIp != null)
				return false;
		} else if (!clientIp.equals(other.clientIp))
			return false;
		if (serverIp == null) {
			if (other.serverIp != null)
				return false;
		} else if (!serverIp.equals(other.serverIp))
			return false;
		if (serverPort == null) {
			if (other.serverPort != null)
				return false;
		} else if (!serverPort.equals(other.serverPort))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SOSRegistered [serverIp=" + serverIp + ", clientIp=" + clientIp
				+ ", serverPort=" + serverPort + "]";
	}
}