package com.feng.util.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisClientImpl implements JedisClient {

	@Autowired
	private JedisPool jedisPool;

	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#get(java.lang.String)
	 */
	@Override
	public String get(String key){
		Jedis jedis = null;
		String value = null;
		try {
			jedis = jedisPool.getResource();
			value = jedis.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return value;
	}
	
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#set(java.lang.String, java.lang.String)
	 */
	@Override
	public String set(String key,String value){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.set(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		} finally {
			jedis.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#del(java.lang.String)
	 */
	@Override
	public Long del(String...keys){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.del(keys);
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		} finally {
			jedis.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#append(java.lang.String, java.lang.String)
	 */
	@Override
	public Long append(String key ,String str){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.append(key, str);
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		} finally {
			jedis.close();
		}
		return res;
	}
	
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#exists(java.lang.String)
	 */
	@Override
	public Boolean exists(String key){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			
			return jedis.exists(key);
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		} finally {
			jedis.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#setnx(java.lang.String, java.lang.String)
	 */
	@Override
	public Long setnx(String key ,String value){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.setnx(key, value);
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0L;
		} finally {
			jedis.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#setex(java.lang.String, java.lang.String, int)
	 */
	@Override
	public String setex(String key,String value,int seconds){
		Jedis jedis = null;
		String res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.setex(key, seconds, value);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#setrange(java.lang.String, java.lang.String, int)
	 */
	@Override
	public Long setrange(String key,String str,int offset){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.setrange(key, offset, str);
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0L;
		} finally {
			jedis.close();
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#mget(java.lang.String)
	 */
	@Override
	public List<String> mget(String...keys){
		Jedis jedis = null;
		List<String> values = null;
		try {
			jedis = jedisPool.getResource();
			values = jedis.mget(keys);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return values;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#mset(java.lang.String)
	 */
	@Override
	public String mset(String...keysvalues){
		Jedis jedis = null;
		String res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.mset(keysvalues);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#msetnx(java.lang.String)
	 */
	@Override
	public Long msetnx(String...keysvalues){
		Jedis jedis = null;
		Long res = 0L;
		try {
			jedis = jedisPool.getResource();
			res =jedis.msetnx(keysvalues);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#getset(java.lang.String, java.lang.String)
	 */
	@Override
	public String getset(String key,String value){
		Jedis jedis = null;
		String res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.getSet(key, value);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#getrange(java.lang.String, int, int)
	 */
	@Override
	public String getrange(String key, int startOffset ,int endOffset){
		Jedis jedis = null;
		String res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.getrange(key, startOffset, endOffset);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#incr(java.lang.String)
	 */
	@Override
	public Long incr(String key){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.incr(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#incrBy(java.lang.String, java.lang.Long)
	 */
	@Override
	public Long incrBy(String key,Long integer){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.incrBy(key, integer);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#decr(java.lang.String)
	 */
	@Override
	public Long decr(String key) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.decr(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#decrBy(java.lang.String, java.lang.Long)
	 */
	@Override
	public Long decrBy(String key,Long integer){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.decrBy(key, integer);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#serlen(java.lang.String)
	 */
	@Override
	public Long serlen(String key){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.strlen(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#hset(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long hset(String key,String field,String value) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.hset(key, field, value);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#hsetnx(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long hsetnx(String key,String field,String value){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.hsetnx(key, field, value);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#hmset(java.lang.String, java.util.Map)
	 */
	@Override
	public String hmset(String key,Map<String, String> hash){
		Jedis jedis = null;
		String res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.hmset(key, hash);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#hget(java.lang.String, java.lang.String)
	 */
	@Override
	public String hget(String key, String field){
		Jedis jedis = null;
		String res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.hget(key, field);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#hmget(java.lang.String, java.lang.String)
	 */
	@Override
	public List<String> hmget(String key,String...fields){
		Jedis jedis = null;
		List<String> res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.hmget(key, fields);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#hincrby(java.lang.String, java.lang.String, java.lang.Long)
	 */
	@Override
	public Long hincrby(String key ,String field ,Long value){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.hincrBy(key, field, value);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#hexists(java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean hexists(String key , String field){
		Jedis jedis = null;
		Boolean res = false;
		try {
			jedis = jedisPool.getResource();
			res = jedis.hexists(key, field);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#hlen(java.lang.String)
	 */
	@Override
	public Long hlen(String key){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.hlen(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
		
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#hdel(java.lang.String, java.lang.String)
	 */
	@Override
	public Long hdel(String key ,String...fields){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.hdel(key, fields);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#hkeys(java.lang.String)
	 */
	@Override
	public Set<String> hkeys(String key){
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.hkeys(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#hvals(java.lang.String)
	 */
	@Override
	public List<String> hvals(String key){
		Jedis jedis = null;
		List<String> res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.hvals(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#hgetall(java.lang.String)
	 */
	@Override
	public Map<String, String> hgetall(String key){
		Jedis jedis = null;
		Map<String, String> res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.hgetAll(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#lpush(java.lang.String, java.lang.String)
	 */
	@Override
	public Long lpush(String key ,String...strs){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.lpush(key, strs);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#rpush(java.lang.String, java.lang.String)
	 */
	@Override
	public Long rpush(String key ,String...strs){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.rpush(key, strs);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#linsert(java.lang.String, redis.clients.jedis.BinaryClient.LIST_POSITION, java.lang.String, java.lang.String)
	 */
	@Override
	public Long linsert(String key, LIST_POSITION where,
		    String pivot, String value){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.linsert(key, where, pivot, value);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#lset(java.lang.String, java.lang.Long, java.lang.String)
	 */
	@Override
	public String lset(String key ,Long index, String value){
		Jedis jedis = null;
		String res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.lset(key, index, value);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#lrem(java.lang.String, long, java.lang.String)
	 */
	@Override
	public Long lrem(String key,long count,String value){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.lrem(key, count, value);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#ltrim(java.lang.String, long, long)
	 */
	@Override
	public String ltrim(String key ,long start ,long end){
		Jedis jedis = null;
		String res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.ltrim(key, start, end);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#lpop(java.lang.String)
	 */
	@Override
	public String lpop(String key){
		Jedis jedis = null;
		String res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.lpop(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#rpop(java.lang.String)
	 */
	@Override
	public String rpop(String key){
		Jedis jedis = null;
		String res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.rpop(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#rpoplpush(java.lang.String, java.lang.String)
	 */
	@Override
	public String rpoplpush(String srckey, String dstkey){
		Jedis jedis = null;
		String res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.rpoplpush(srckey, dstkey);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#lindex(java.lang.String, long)
	 */
	@Override
	public String lindex(String key,long index){
		Jedis jedis = null;
		String res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.lindex(key, index);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#llen(java.lang.String)
	 */
	@Override
	public Long llen(String key){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.llen(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#lrange(java.lang.String, long, long)
	 */
	@Override
	public List<String> lrange(String key,long start,long end){
		Jedis jedis = null;
		List<String> res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.lrange(key, start, end);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#sadd(java.lang.String, java.lang.String)
	 */
	@Override
	public Long sadd(String key,String...members){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.sadd(key, members);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#srem(java.lang.String, java.lang.String)
	 */
	@Override
	public Long srem(String key,String...members){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.srem(key, members);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#spop(java.lang.String)
	 */
	@Override
	public String spop(String key){
		Jedis jedis = null;
		String res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.spop(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#sdiff(java.lang.String)
	 */
	@Override
	public Set<String> sdiff(String...keys){
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.sdiff(keys);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#sdiffstore(java.lang.String, java.lang.String)
	 */
	@Override
	public Long sdiffstore(String dstkey,String... keys){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.sdiffstore(dstkey, keys);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#sinter(java.lang.String)
	 */
	@Override
	public Set<String> sinter(String...keys){
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.sinter(keys);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#sinterstore(java.lang.String, java.lang.String)
	 */
	@Override
	public Long sinterstore(String dstkey,String...keys){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.sinterstore(dstkey, keys);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#sunion(java.lang.String)
	 */
	@Override
	public Set<String> sunion(String... keys){
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.sunion(keys);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#sunionstore(java.lang.String, java.lang.String)
	 */
	@Override
	public Long sunionstore(String dstkey,String...keys){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.sunionstore(dstkey, keys);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#smove(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long smove(String srckey, String dstkey, String member){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.smove(srckey, dstkey, member);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#scard(java.lang.String)
	 */
	@Override
	public Long scard(String key){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.scard(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#sismember(java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean sismember(String key,String member){
		Jedis jedis = null;
		Boolean res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.sismember(key, member);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#srandmember(java.lang.String)
	 */
	@Override
	public String srandmember(String key){
		Jedis jedis = null;
		String res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.srandmember(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#smembers(java.lang.String)
	 */
	@Override
	public Set<String> smembers(String key){
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.smembers(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#zadd(java.lang.String, java.util.Map)
	 */
	@Override
	public Long zadd(String key,Map<String, Double> scoreMembers){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.zadd(key, scoreMembers);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#zadd(java.lang.String, double, java.lang.String)
	 */
	@Override
	public Long zadd(String key,double score,String member){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.zadd(key, score, member);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#zrem(java.lang.String, java.lang.String)
	 */
	@Override
	public Long zrem(String key,String...members){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.zrem(key, members);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#zincrby(java.lang.String, double, java.lang.String)
	 */
	@Override
	public Double zincrby(String key ,double score ,String member){
		Jedis jedis = null;
		Double res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.zincrby(key, score, member);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#zrank(java.lang.String, java.lang.String)
	 */
	@Override
	public Long zrank(String key,String member){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.zrank(key, member);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#zrevrank(java.lang.String, java.lang.String)
	 */
	@Override
	public Long zrevrank(String key,String member){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.zrevrank(key, member);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#zrevrange(java.lang.String, long, long)
	 */
	@Override
	public Set<String> zrevrange(String key ,long start ,long end){
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.zrevrange(key, start, end);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#zrangebyscore(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Set<String> zrangebyscore(String key,String max,String min){
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.zrevrangeByScore(key, max, min);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#zrangeByScore(java.lang.String, double, double)
	 */
	@Override
	public Set<String> zrangeByScore(String key ,double max,double min){
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.zrevrangeByScore(key,max,min);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#zcount(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long zcount(String key,String min,String max){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.zcount(key, min, max);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#zcard(java.lang.String)
	 */
	@Override
	public Long zcard(String key){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.zcard(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#zscore(java.lang.String, java.lang.String)
	 */
	@Override
	public Double zscore(String key,String member){
		Jedis jedis = null;
		Double res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.zscore(key, member);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#zremrangeByRank(java.lang.String, long, long)
	 */
	@Override
	public Long zremrangeByRank(String key ,long start, long end){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.zremrangeByRank(key, start, end);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#zremrangeByScore(java.lang.String, double, double)
	 */
	@Override
	public Long zremrangeByScore(String key,double start,double end){
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.zremrangeByScore(key, start, end);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#keys(java.lang.String)
	 */
	@Override
	public Set<String> keys(String pattern){
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.keys(pattern);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.feng.base.JedisClient#type(java.lang.String)
	 */
	@Override
	public String type(String key){
		Jedis jedis = null;
		String res = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.type(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return res;
	}
	
}
