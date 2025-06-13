package Problems;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Prob2092 {
	static String str1;
	static void test() {
		
		Path filePath = Paths.get("./TestFiles/Prob2092.dat");
		
        try { 
            List<String> lines = Files.readAllLines(filePath);
            
            for (int i=0; i<lines.size(); i++) {
            	if (!lines.get(i).equalsIgnoreCase("test_str_data_begin")) {
            		continue;
            	}//fi
            	Field field = Prob2092.class.getDeclaredField(lines.get(i+1));
            	field.set(null, lines.get(i+2));
            	
				
            }//rof
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();       
        } catch (IOException e) {
            e.printStackTrace();
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end try catch
        
		Solution2092 solObj = new Solution2092();
		CorrectSolution2092 correctSolObj = new CorrectSolution2092();
		List<Integer> solList, correctSolList;
		
		int[][] meetings;
		int n, firstPerson;
		
		try {
            // Create an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            
            
            n = 50000;
            firstPerson = 1;            
            meetings = objectMapper.readValue(str1, int[][].class);
    		solList = solObj.findAllPeople(n, meetings, firstPerson);
    		correctSolList = correctSolObj.findAllPeople(n, meetings, firstPerson);
    		System.out.println("sol: " + solList);
    		System.out.println("C s: " + correctSolList);
            
    		
            
            n = 8;
            firstPerson = 5;            
            meetings = objectMapper.readValue("[[3, 4, 1], [1, 4, 1],  [1, 5, 1],  [3, 7, 3]]", int[][].class);
    		solList = solObj.findAllPeople(n, meetings, firstPerson);
    		correctSolList = correctSolObj.findAllPeople(n, meetings, firstPerson);
    		System.out.println("sol: " + solList);
    		System.out.println("C s: " + correctSolList);
    		
            n = 6;
            firstPerson = 1;            
            meetings = objectMapper.readValue("[[1,2,5],[2,3,8],[1,5,10]]", int[][].class);
    		solList = solObj.findAllPeople(n, meetings, firstPerson);
    		System.out.println("sol: " + solList);
    		
    	
    		
            n = 4;
            firstPerson = 3;            
            meetings = objectMapper.readValue("[[3,1,3],[1,2,2],[0,3,3]]", int[][].class);
    		solList = solObj.findAllPeople(n, meetings, firstPerson);
    		correctSolList = correctSolObj.findAllPeople(n, meetings, firstPerson);
    		System.out.println("sol: " + solList);
    		System.out.println("C s: " + correctSolList);
    		//*/
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	static void test2() {
		Solution2092 solObj = new Solution2092();
		//solObj.test();

	}
	
	public static void main(String[] args) {

		test();
		//test2();

	}

}


class Solution2092 {
	
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
    	
    	//step 1, sort meeting according to time
    	Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));
    	//System.out.println(" aa: " + Arrays.deepToString(meetings));
    	
    	//step 2, expending secret holding group
    	Integer[] currRelationArr = new Integer[n+1];
    	currRelationArr[0] = 0; //now, secret holding group's id is always 0
    	currRelationArr[firstPerson] = 0;
    	Integer groupID;
    	int currItrTime = 0;
    	Set<Integer> participantSet = new HashSet<>();
    	
    	for (int[] meeting:meetings) {   
    		if (meeting[2] != currItrTime) {//new time frame has arrived       			
    			currItrTime = meeting[2];    			
    			//System.out.println(" prevRelationArr: " + Arrays.toString(prevRelationArr));
    			for (Integer personID:participantSet) {
    				groupID = findAndUpdateGroupID(currRelationArr, personID);
    				if (groupID == null || groupID != 0) {//is not secret holding group, nullify it   
    					currRelationArr[personID]=null;
        			}//fi
        		}//rof      			 
    			participantSet = new HashSet<>();
    		}//fi
    		offerRelation(currRelationArr, meeting[0], meeting[1]);      
    		participantSet.add(meeting[0]);
    		participantSet.add(meeting[1]);
    	}//rof

    	//System.out.println(" relationArr: " + Arrays.toString(currRelationArr));
    	
    	//step 3, now scan through last meeting group and add those belong to group id 0
    	List<Integer> secretHolderList = new ArrayList<>(n);
		for (int personID = 0; personID <= n; personID++) {
			groupID = findAndUpdateGroupID(currRelationArr, personID);
			if (groupID == null) {
				continue;
			} else if (groupID == 0) {//is secret holding group, so this person knows secret                				
				secretHolderList.add(personID);
			}//fi
		}//rof 
  
        return secretHolderList;
    }//end method
    
    /**
     * offer relation to relation array 
     * precondition:
     * - assume relation array is valid
     * @param relationArr - Integer[], index is person id, value is group id 
     * @param personA - Integer, person id of A
     * @param personB - Integer, person id of B
     */
    private void offerRelation(Integer[] relationArr, Integer personA, Integer personB) {
    	
    	Integer groupA = findAndUpdateGroupID(relationArr, personA);
    	Integer groupB = findAndUpdateGroupID(relationArr, personB);
    	if (groupA==null && groupB==null) {
    		if (personA>personB) { //select smallest id as group root 
    			relationArr[personA] = personB;
    			relationArr[personB] = personB;
    		} else {
    			relationArr[personA] = personA;
    			relationArr[personB] = personA;
    		}//fi
    	} else if (groupA == null) { // person A previously has not joined any meeting
    		relationArr[personA] = groupB;
    	} else if (groupB == null) {// person BA previously has not joined any meeting
    		relationArr[personB] = groupA;
    	} else if (groupA>groupB) { //join and select smallest id as group root 
			relationArr[groupA] = groupB;
		} else {
			relationArr[groupB] = groupA;
		}//fi				
    }//end method
    
    /**
     * This method find group id given person id.
     * Group id is assigned to be the smallest person id of the group
     * Meanwhile, it also update group map to reflect new relationship in the meeting group 
     * Precondition:
     * - Assume group relation array is valid
     * @param relationArr - Integer[]
     * @param personID - Integer
     * @return Integer, group ID
     */
    private Integer findAndUpdateGroupID(Integer[] relationArr, Integer personID) {
    	//System.out.println("finding person: " + personID + " relationArr: " + Arrays.toString(relationArr));
    	if (relationArr[personID] == null) {    		
    		return null;
    	} else if (relationArr[personID] == relationArr[relationArr[personID]]) {
    		return relationArr[personID];
    	} else {
    		relationArr[personID] = findAndUpdateGroupID(relationArr, relationArr[personID]);
    		return relationArr[personID];
    	}//fi
    }//end method
        
}//end class



class Solution2092_v2 {
	
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
    	
    	//step 1, sort meeting according to time
    	Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));
    	//System.out.println(" aa: " + Arrays.deepToString(meetings));
    	
    	//step 2, expending secret holding group . group relation array are alternating to save memory space
    	Integer[] prevRelationArr;
    	Integer[] currRelationArr = new Integer[n+1];
    	currRelationArr[0] = 0; //now, secret holding group's id is always 0
    	currRelationArr[firstPerson] = 0;
    	int currItrTime = 0;
    	Integer groupID;
    	for (int[] meeting:meetings) {
    		if (meeting[2] != currItrTime) {//new time frame has arrived    		 	
    			prevRelationArr = currRelationArr;
    			currRelationArr = new Integer[n+1];
    			currItrTime = meeting[2];
    			
    			//System.out.println(" prevRelationArr: " + Arrays.toString(prevRelationArr));
    			for (int personID = 0; personID <= n; personID++) {
    				groupID = findAndUpdateGroupID(prevRelationArr, personID);
    				if (groupID == null) {
        				continue;
        			} else if (groupID == 0) {//is secret holding group, so this person knows secret                				
        				currRelationArr[personID]=0; 
        			}//fi
        		}//rof      			    		
    		}//fi
    		//System.out.println(" offer: " + meeting[0] + ":" +  meeting[1]);
    		offerRelation(currRelationArr, meeting[0], meeting[1]);    	
    		//System.out.println(" offerred: " + Arrays.toString(currRelationArr));
    	}//rof

    	//System.out.println(" relationArr: " + Arrays.toString(currRelationArr));
    	
    	//step 3, now scan through last meeting group and add those belong to group id 0
    	List<Integer> secretHolderList = new ArrayList<>(n);
		for (int personID = 0; personID <= n; personID++) {
			groupID = findAndUpdateGroupID(currRelationArr, personID);
			if (groupID == null) {
				continue;
			} else if (groupID == 0) {//is secret holding group, so this person knows secret                				
				secretHolderList.add(personID);
			}//fi
		}//rof 
  
        return secretHolderList;
    }//end method
    
    /**
     * offer relation to relation array 
     * precondition:
     * - assume relation array is valid
     * @param relationArr - Integer[], index is person id, value is group id 
     * @param personA - Integer, person id of A
     * @param personB - Integer, person id of B
     */
    private void offerRelation(Integer[] relationArr, Integer personA, Integer personB) {
    	
    	Integer groupA = findAndUpdateGroupID(relationArr, personA);
    	Integer groupB = findAndUpdateGroupID(relationArr, personB);
    	if (groupA==null && groupB==null) {
    		if (personA>personB) { //select smallest id as group root 
    			relationArr[personA] = personB;
    			relationArr[personB] = personB;
    		} else {
    			relationArr[personA] = personA;
    			relationArr[personB] = personA;
    		}//fi
    	} else if (groupA == null) { // person A previously has not joined any meeting
    		relationArr[personA] = groupB;
    	} else if (groupB == null) {// person BA previously has not joined any meeting
    		relationArr[personB] = groupA;
    	} else if (groupA>groupB) { //join and select smallest id as group root 
			relationArr[groupA] = groupB;
		} else {
			relationArr[groupB] = groupA;
		}//fi				
    }//end method
    
    /**
     * This method find group id given person id.
     * Group id is assigned to be the smallest person id of the group
     * Meanwhile, it also update group map to reflect new relationship in the meeting group 
     * Precondition:
     * - Assume group relation array is valid
     * @param relationArr - Integer[]
     * @param personID - Integer
     * @return Integer, group ID
     */
    private Integer findAndUpdateGroupID(Integer[] relationArr, Integer personID) {
    	//System.out.println("finding person: " + personID + " relationArr: " + Arrays.toString(relationArr));
    	Integer nextPersonID;
    	if ((nextPersonID=relationArr[personID])==null) {    		
    		return null;
    	} else if (nextPersonID == relationArr[nextPersonID]) {
    		return nextPersonID;
    	} else {
    		relationArr[personID] = findAndUpdateGroupID(relationArr, nextPersonID);
    		return relationArr[personID];
    	}//fi
    }//end method
        
}//end class


class CorrectSolution2092 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
	
        Arrays.sort(meetings, ((a,b)->a[2]-b[2]));
        
        UF uf = new UF(n);
        uf.union(0, firstPerson); // base
		
		// for every time we have a pool of people that talk to each other
		// if someone knows a secret proir to this meeting - all pool will too
		// if not - reset unions from this pool
        int i = 0;
        while (i < meetings.length) {
            int curTime = meetings[i][2];
            Set<Integer> pool = new HashSet<>();
            
            while (i < meetings.length && curTime == meetings[i][2]) {
                int[] currentMeeting = meetings[i];
                uf.union(currentMeeting[0], currentMeeting[1]);
                pool.add(currentMeeting[0]);
                pool.add(currentMeeting[1]);
                i++;
            }
            			
			// meeting that took place now should't affect future
			// meetings if people don't know the secret
            for (int j : pool) if (!uf.connected(0, j)) uf.reset(j);
        }
		
		// if the person is conneted to 0 - they know a secret
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < n; j++) if (uf.connected(j,0)) ans.add(j);
        return ans;
    }
    
	// regular union find
    private static class UF {
        int[] parent, rank;
		
        public UF(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ)
                return;

            if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }
        
        public int find(int p) {
            while (parent[p] != p) {
                p = parent[parent[p]];
            }
            return p;
        }
        
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
        
        public void reset(int p) {
            parent[p] = p;
            rank[p] = 0;
        }
    }
}
