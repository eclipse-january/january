package org.eclipse.dawnsci.analysis.api.metadata;

/**
 * This metadata is set by a remote dataset.
 * 
 * It provides information about dropped data and
 * received data while the dataset is connected.
 * 
 * Not all remote datasets are foced to provide this information.
 * 
 * This class is set in bundle org.eclipse.dawnsci.remotedataset.client 
 * as metadata on RemoteDatasets returned from the Data Server
 * 
 */
public class DynamicConnectionInfo implements MetadataType {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3982740822246879131L;
	
	private long receivedCount;
	private long droppedCount;
	private boolean connected;
	
	
	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (connected ? 1231 : 1237);
		result = prime * result + (int) (droppedCount ^ (droppedCount >>> 32));
		result = prime * result + (int) (receivedCount ^ (receivedCount >>> 32));
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
		DynamicConnectionInfo other = (DynamicConnectionInfo) obj;
		if (connected != other.connected)
			return false;
		if (droppedCount != other.droppedCount)
			return false;
		if (receivedCount != other.receivedCount)
			return false;
		return true;
	}

	public long getReceivedCount() {
		return receivedCount;
	}

	public void setReceivedCount(int receivedCount) {
		this.receivedCount = receivedCount;
	}

	public long getDroppedCount() {
		return droppedCount;
	}

	public void setDroppedCount(int droppedCount) {
		this.droppedCount = droppedCount;
	}

	/**
	 * Make a deep copy of metadata
	 * @return clone
	 */
	public MetadataType clone() {
		DynamicConnectionInfo info = new DynamicConnectionInfo();
		info.receivedCount = this.receivedCount;
		info.droppedCount  = this.droppedCount;
		return info;
	}

}
