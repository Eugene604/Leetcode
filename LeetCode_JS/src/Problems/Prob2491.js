/**
 * @param {number[]} skill
 * @return {number}
 */
var dividePlayers = function(skill) {
    skill.sort((a,b)=>a-b);
    //console.log(skill);    
    const teamSkill = skill[0] + skill[skill.length-1];
    let totalChemistry = skill[0] * skill[skill.length-1];
    
    //edge case:
    if (skill.length === 2){
		return totalChemistry;
	}//fi
	
    for (let leftInx=1, rightInx=skill.length-2; leftInx<rightInx; leftInx++, rightInx-- ){
		if (teamSkill !== skill[leftInx] + skill[rightInx]){
			return -1;
		}//fi
		totalChemistry += skill[leftInx] * skill[rightInx];
	}//rof
	return totalChemistry;
};


var testFunc = function() {
	let skill;

	skill  = [3,2,5,1,3,4];
	
	console.log("ans: " + dividePlayers(skill));

	
	/*
	

	//*/
};



testFunc();


