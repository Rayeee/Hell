package winter.hell.redis.utils;

public enum RedisKey {
	
	LOCATION_ENABLE_TRACE_FOR_USER("LOCATION_ENABLE_TRACE_FOR_USER"),
	POSITION_TRACK_FOR_USER("POSITION_TRACK_FOR_USER"),
	TOKEN_MAPPING_USERID("TOKEN_MAPPING_USERID"),
	TOKEN_INFO("TOKEN_INFO_");
	
	private String key;

	private RedisKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public String getName() {
		return this.name();
	}
}
