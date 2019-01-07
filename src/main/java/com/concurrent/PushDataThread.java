package com.concurrent;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:50
 */
public class PushDataThread extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "push");
			/*
			long start = System.currentTimeMillis();
			int queue = ThreadConstants.uploadOriginalDataQueue.size();
				try {
					if (queue == 0) {
						Thread.sleep(ThreadConstants.writeWaitTime);
					} else {
						List<Map<String, Object>> correctList = new ArrayList<Map<String, Object>>();
						if(queue>200) queue=200;
						
						for(int i=0;i<queue;i++){
							//synchronized(ThreadConstants.mpiLinkedQueue) {
							Map map = (Map) ThreadConstants.uploadOriginalDataQueue.poll();
							if(map!=null)correctList.add(map);
							//}
						}
						boolean flag = pushCorrectDataByRpc(correctList);
						if(flag){
							List<String> events = new ArrayList<String>();
							for(Map<String, Object> data : correctList){
								events.add((String) data.get("EventId"));
							}
							setRightFlag(events,session);
							logger.info("成功上传Original数据:"+correctList.size()+"条.");
						}
					}
				} catch (Exception e) {
					logger.error("datapush thread appear error:["
							+ e.getMessage() + "].");
					e.printStackTrace();
				}finally{
					session.close();
					long end = System.currentTimeMillis();
					logger.info("成功上传OriginalData数据200条.cost:"+(end-start)+"ms");
				}
		*/
        }
    }

    /**
     * RPC推送正确数据
     *
     * @param list
     * @return
     */
    private boolean pushCorrectDataByRpc(List<Map<String, Object>> list) {
        boolean flag = false;

        return flag;
    }

    public void setRightFlag() {

    }
}
