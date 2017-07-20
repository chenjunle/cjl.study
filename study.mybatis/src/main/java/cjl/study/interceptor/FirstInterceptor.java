package cjl.study.interceptor;

import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Intercepts(
	@Signature(
		type=ResultSetHandler.class,
		method="handleResultSets",
		args={Statement.class})
	)
@SuppressWarnings("unchecked")
public class FirstInterceptor implements Interceptor{
	
	private static Logger logger = LoggerFactory.getLogger(FirstInterceptor.class);

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		List<Object> result = (List<Object>)invocation.proceed();
		for(Object obj:result){
			if(obj instanceof Map){
				processMap((Map)obj);
			}else{
				break;
			}
		}
		return result;
	}

	/**
	 * 处理map中的键，将下划线转换为驼峰命名
	 * @param map
	 */
	private void processMap(Map<String,Object> map) {
		if(map == null){
			logger.debug("----------------待转换的map为空,转换失败----------------");
			return;
		}
		Set<String> stringSet = new HashSet<>(map.keySet());
		for(String key:stringSet){
			Object value = map.get(key);
			String oldKey = key;
			key.toLowerCase();
			if(key.contains("_")){
				key = underLineToCameHump(key);
				map.put(key, value);
				map.remove(oldKey);
			}
		}
	}

	/**
	 * 将key转换为驼峰命名
	 * @param key
	 * @return
	 */
	private String underLineToCameHump(String key) {
		if(key == null || "".equals(key))
			return key;
		StringBuffer sb = new StringBuffer();
		boolean nextUpper = false;
		for(int i=0; i<key.length() ; i++){
			char c = key.charAt(i);
			if(c == '_'){
				nextUpper = true;
			}else{
				if(nextUpper){
					sb.append(Character.toUpperCase(c));
					nextUpper = false;
				}else{
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}

	
	
}
