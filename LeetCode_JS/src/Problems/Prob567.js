/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var checkInclusion = function(s1, s2) {
	//edge case - insufficient length for s2
	if (s2.length < s1.length){
		return false;
	}//fi
	
	//step 1, populate frequencies of each character in s1
	let targetFreqArr = new Array(128).fill(Number.MIN_SAFE_INTEGER);
	let currChrCode;
	let numOfUnmatchedChars = 0;
	for (let i=0; i<s1.length; i++){
		currChrCode = s1.charCodeAt(i);
		if (targetFreqArr[currChrCode] === Number.MIN_SAFE_INTEGER){
			targetFreqArr[currChrCode] = 1;
			numOfUnmatchedChars++;
		} else {
			targetFreqArr[currChrCode]++;
		}//fi
	}//rof
	
	//console.log(targetFreqArr.slice(97,125));
		
	//step 2: part 1 of sliding window algorithm: get first window
	
	for (let i=0; i<s1.length; i++){
		currChrCode = s2.charCodeAt(i);
		targetFreqArr[currChrCode] = targetFreqArr[currChrCode];
		if (targetFreqArr[currChrCode] === 1){
			targetFreqArr[currChrCode]--;
			numOfUnmatchedChars--;
		} else if (targetFreqArr[currChrCode] === 0) {
			targetFreqArr[currChrCode]--;
			numOfUnmatchedChars++;
		} else if (targetFreqArr[currChrCode] === Number.MIN_SAFE_INTEGER) {
			//do nothing
		} else {
			targetFreqArr[currChrCode]--;
		}//fi
	}//rof
	
	//console.log(targetFreqArr.slice(97,125));
	
	//edge case: first slide window already matches
	if (numOfUnmatchedChars === 0){
		return true;
	}//fi
	
	//step 3: part two of sliding window algorithm
	for (let leftInx=1, rightInx=s1.length; rightInx < s2.length; leftInx++, rightInx++){
		//this part is to reduce targetFreqArr[currChrCode] from target targetFreqArr[currChrCode] map (add character means decrease required targetFreqArr[currChrCode])
		currChrCode = s2.charCodeAt(rightInx);
		if (targetFreqArr[currChrCode] === 1){
			targetFreqArr[currChrCode]--;
			numOfUnmatchedChars--;
		} else if (targetFreqArr[currChrCode] === 0) {
			targetFreqArr[currChrCode]--;
			numOfUnmatchedChars++;
		} else if (targetFreqArr[currChrCode] === Number.MIN_SAFE_INTEGER) {
			//do nothing
		} else {
			targetFreqArr[currChrCode]--;
		}//fi
		
		//this part is to add to target targetFreqArr[currChrCode] map
		currChrCode = s2.charCodeAt(leftInx-1);
		if (targetFreqArr[currChrCode] === -1){
			targetFreqArr[currChrCode]++;
			numOfUnmatchedChars--;
		} else if (targetFreqArr[currChrCode] === 0) {
			targetFreqArr[currChrCode]++;
			numOfUnmatchedChars++;
		} else if (targetFreqArr[currChrCode] === Number.MIN_SAFE_INTEGER) {
			//do nothing
		} else {
			targetFreqArr[currChrCode]++;
		}//fi
		
		if (numOfUnmatchedChars === 0){
			return true;
		}//fi
	}//rof

    return false;
};

var testFunc = function() {
	let s1, s2;

	s1 = "paoolrbebsqumnolusfdaavvkdmyulelajnilqxsujdycieizlwvuwcnwfemijpyixbjamphkufjfvfvjvdjbdkthlxrtyahuifdjqlvpvccajaosgffminewnhyzymgvwbsgirfwnjszjswffrolsuupwkiwjjtbcgqbyarskbyxdigcusygjpvdcubzmmpfzzwhuwibivbxjklpptfryfbamafxuzpzagivenlctomtcymlmkbzozyncdwvabqjvvzuwivzfjcqhrixwinyxqsnckkhjmfsomdkujzecihamydgkyntwztemhawvxpahtiwrjwysrzmrhwxkbazynwmgtyclyjqsrfkddjdmvxhtwnvxrlxfxnpyevsafmqmbvbnueqxegkcuwzwdmqqpdlegyrjhgytgfxtzagazguoadzycnwwhdlkogbzrwiwjxxvlpvxfbtrxtqahcfrbzixqyftlddwmwtorfvjzenksaukrevkddgnafwqtgsizisktrrmqvkeagjngtngqiithdxxefqpcdwmglvvjerwcwitdzlsozczimmbwxwvpccjyemhyyekruqejgrnhpfnxiodwmworpenustqtaswegjordqwqmdsmgbpxytptvnwtjmxwhfsnszscafeiyyuikthfnzcoassldzlkdgclyezsquhksisjvmcsxlwdpplwrwxthuipsjjfhtfqhcrnfcomnkbthyvhaelbtsyhrmjharxzhymxxbcwtxansrcwqsgzzdxzcqbphtccnjhikhhovezgbkgcwkavkrbydyctgizqferucmghsihyxgbpmehtwpwcwunitcrgdmcnodipruqegudtkluswpnvbdqyukspwvgchexiaxuebqfvitnmukebchkzmtnwcuymbnmyqgmzefnelwqnhleaadekwjehlkydpuwybendymsluptckrvbglxmamohiyszwkslittmdbfmxkmqomxfuskubytbgfvnlebmzxcsreqnjuctcjriszjpojywsitudelqljtufsbxmnykadnryjz";
	
	s2 = "pwjurfxfwxotemsiyitndgrtvzksgniyqolgwfhofhmnwmxbmphratrwdskjwutemrzivnndkxfmzzpenueyiztqcydbeftbuobqwyazibaettbqbueeaiayutaoqvmckemxhrecvptegifgemdsjkepzsedvkfixtvikviadomqsrwowftrnqdumlabwtbfsxkoytkgznmkfzbtntumlbjhxeaoxbuoshxsjnosnsrtzrtcqdifbiyvmrbwteajksskklrpkmbylwwprapfdhujoigcrqhtgtwolwjmoudnzlnmpnchwslpibwvffbcbbefpvfygnpluzyjrqipupidoxtgglbvnxmtzjaglglpkryudoskkyspuxmxrkmcxkueluiuvxsdwkorxgjikyoniicljvddfgfuhujplkakjnvskuozvmmavmyzdgzbohjrnfvsslyarxscfxscijsyhcqxnceqfavyzofvysilqdnpjypgtpjatklrnzhkygyfoaupibuqtuxbfsfcawiiulgohigutukhywypthyymvcabnsdsjtrdrtmifarhrcimzrpcbdfjtpwqsndlpiuletacqcccpnziupvclsinkdffnojfrvgypdajujzkdixugrbhqmwyjztfvvokmgdrbfmrdprmzoslldcssvkofxqsdrwapobietvmoonfipeejlgtuvpcbcfnsmupwjsgliheexediefcfrglliqoxjjsdjtpehqmkxkvkkflhwbvohryjpfgebcvkjqtcetxzhtfysomusfzsztqweekxbdcruwjgpdrwokseyaqznhihjulevycglkuacfgzlargjoquxoupfrhdegpqzrshmbierjjvzsdwsibinlrslimfgrsaacxijthbzmxnyuslffnfxziudxcdwfwnkmdeucbyydkhqkestxzvdraxjjcuzdgayabmxsltqdnsikxaasugkcovnvwfxiuozaphegpkhtmtqxxmwhrtblrtxvrtidkcluorcrksklgmismylsrwwtlhlnqnqlfmmefzltunpqozqpnxhtqvpovckbiaaejtwejjuuzmtargntaqehigzibxfczkwcthqijyhcdtupeqbtnnorrgmktlsgjortvsgjhrgzccgvlfjeqjfywufbqwnerpzxlnczxwjttiiokqfigqhgqaatzwynivuhpukuzgsijrfpganfroohnruzlijwinapnemwsxveqfremhwqwqwhxlmvfsnuglnkkqynvflxgdqayxpklerojawlidelttqlfvfmjoiwhylwrillyjjoxrfkayddfeytomjphsgzzbgxhbgdwonzrqrcbnrztgvoodyxrzbinqgeaptvyfkdizuzbxdiulvfqlsllkxkvmprritvhkdoghouifwpprblaeauyxyhlipccqjnorphmrelbsashkmmhnperidnmmizijbtfqkhgboniuphozbdgmlfieqjjpywvqggmsliocmvdkhxszrvqyjoxdvspqlljtbztjybmpwebavgmldxxohjfrmxpljszfjploblpsenjxqxdvmmwljoxmagpgxunlnoibvupfluyclemsywizdmrzchiujcqnlmcjkutxbzeibruvvknviojcflxfhyjhjkwerwgfowucgtyrimxiehdgwrifbpdaaqffgzssxiemrcyxpezijuyptdynatoivsqbkqbgutgmikqywkhcwhknunsnfsdkkhwwxvttohjwydlzihsjtwbzbtbemhssndaubxegtvinucugvvascicyfgqnhsidgcrrctjwrjjqbgcsfioebytsmalmnnnpznxcjlyvfykwsqbewxfgiazugkqdoggrjukpplsnaovwsliyiojnyhmiloyjkkwtrdcsyjxllfhvizydwlqlojidvzjylhzfvksneyduudibadamaoifenrvdduvljircjtlnohxxckjnfeiaagyqxyoyezloucybulpjrlhdwkdkagbukvjrkxjddpsahymtcfaivfaeioyynxykdacbloejpnnhtcxepzzuhzrnjrmpwvngrivioukkolckoskxjmjyzaqysaqbjevvqibbimxhehlkuyknwqkhfabgdnuwgzofmyetruzxszdcypmqouxyqyuvfvijircklyfifwbypgwbwvwrvxxmoyzdlpecfsbinlthrdnckqagstfgyzhduluvscnmmwzapxaraxcvkndddlfrcnzpkyhksxerhgaulwetciqaefwmmzdsqfldtouxlqqgrqsvksyrnspqmkiewwhrjkoahzpacgylikhnoswnsyzuvxzdrlxgcfflogzezkofstastmpvftshxvizunhsuakqqjscycfrqejprsogqzlkuskvnbgbjisbasgdjlmgpiklkhbfoaqjfrjmmtzfggyrsyymtfkuuqtrbvtnnzcaiuqjlgosortmyjqqzmadqgjijrofedppddtfdyijinvxehpbanizoqtowugvzflscmcfqelycotzwpwhxzmdsaxrwhgvlaookontbwunqfiuxarlztainztyooiuazebwmukvgcpvnkllkjoazejdmocpeuurhfarzjdybgxusmocaiaqxicgdorwdrvrrmjczfajbbmjnmvohjfsprufofokpaoolrbebsqumnolusfdaavvkdmyelelajniwqxsujdycieizlwviwcnwfcmijpyixbjamphkufkmvfvjvdjbdkthlxrtyahuifdjqlvpvccajaosgffminewnhyzymgvwbsgirfwnjszjswffkolsuupwkiwjjtbcgqbyarskbyxdigcusygjpvdcubzmmpfzzwhuwibivbxjklpptfryfbamafxuzpzagivenlctomtcymlmkbzozyncdwvabqjvvbuwivzfjcqhrixwinyxqsnckkhimfsomdkujtecihamydgkyntwztemhawvxpahtiwrjwysrzmrhwxkfazynwmgtyclyjqsrfkddjdmvxhzwnvxrlxfxnpyevsafmqmbvbnueqxegkcuwzidmqqpdlegyrjhgytgfxtzagazguoydzycnwwhdlkogbzrwiwjxxvlgvxfbtrxtqahcfrbzixqyftlddwmwtorfvjzenksaukrevkddgnafwqtgswzisktrrmqvkeagjngtnjqiithdxxefqpcdwmglvvjerwcwitdzlsozczimmbwxwvpccjyemhyyekruqejgrnhpfnxjodwmworpenustqoaswegjordqlqmdsmgbpxytptvnwtjmxwhfsnszscafeiyyuikthfnzcoassldzlkdgclyezsquhksisjvmcsxlwdpplwrwxthuupsjjfhtfqhcrnfcomnkbthyvhaelbtsyhrhjharxzhymxxbcwtxansrcwqsgzzdxzcqbpmtccnjhikhhovezgbkgcwkavkrbydyctgizqferucmghsihyxgbpmehtwpwewunitcrgdmcnodipruqegudtkluswpnvbdqyukspwvgchexiakuebqfvitnmukebchkzmtnwcuymbnmyqgfzefnelwqnhleaadekwjehljydpuwybendymsluptckrvbplxmamohiyszwrslittmdbfmxkmqtmxfusxubatbgfvnlebmzxcsruqnjuctcjriszjpogywsitudelqljtubszxmnykadnryjzhosyorgzvpzolmpbafnvcrrzfaxoqaulbcbnrucuydqbppnpgrdoyugbpiqdafccgordlqbwcgzirbbpaftoqtujqrljdqjrtwaqskcfqjqhvlgzbdmarajevjjrphkdzturmpqomzcewxxrpglsjehpfhmwmgeotxbswzswftewfchvxpqjyzlwwkxmssxpmdrtclakalcsgpwkvntjshydpvjauqilqkeyjojgehwwlattlhlgdgpotxhlrmffspdyxmjfonkzwdjkambqnwicehfzjvrxwsrbkztmtermdjjlaxlremdxnnfavmtclhvhesujoasmqonrjzlznywprupsfdafmuhunpigohenjnmpwdxcolvwuyptjigbihzcotxqjgskupqeomwlosbxqdjxwhmifbxzptjmvnfbpswtbjlmijpprzfelgzxbigrijgxlvmurzdvhxskpczyqrdelsyuqmfdxhzodxlhtsfxapwreaqtmzdhkibnwvsfsdolvwzwwjmgysrqfihakhhbbpfhbtvknsenzyvwyzudvvwgxjavcjyweomjfkucztlevmbbxqwznytbhdaowmecfkcfmiyvcfundeflybuifpvkvezezadmauwjzyfmdkxdvsfqkdkwydqhmmxfblfhnzqanonlmj";
	
	console.log("ans: " + checkInclusion(s1, s2));
	console.log("ans: " + checkInclusion_correct(s1, s2));
	
	/*
	

	//*/
};


//  s1 = "ab", s2 = "eidbaooo"
function checkInclusion_correct(s1, s2) {
	// If s1 is larger than s2 then match is not possible
	// i.e (s1 cannot be substring of s2)
	if (s1.length > s2.length) return false;
	let neededChar = {}; //To Store the frequency/count of required string s1
	for (let i = 0; i < s1.length; i++) {
		// Initially neededChar[s1[i]] will be undefined and
		// undefined || 0 will return 0. So we increment it by 1
		neededChar[s1[i]] = (neededChar[s1[i]] || 0) + 1;
	}
	/* 
	Now we have neededChar
	i.e neededChar={
		a:1,
		b:1
	}
	*/
	let left = 0, //left pointer/index of the sliding window
		right = 0, //right pointer/index of the sliding window
		requiredLength = s1.length; //length of the substring required in s2

	// Now iterate until the right index of window is lesser than length of s2
	while (right < s2.length) {
		// If we found s2 character in s1 i.e in neededChar then we decrease requiredLength
		if (neededChar[s2[right]] > 0) requiredLength--;
		// Since we have encountered new char i.e s2[right] we decrease it's 
		// count in neededChar even if it is not present in neededChar because we only care about neededChars
		neededChar[s2[right]]--;
		right++ //window is incremented by 1 step

		// Now if our requiredLength becomes 0 it means we have found a match of the s2 substring
		// So we return true
		if (requiredLength === 0) return true;

		// If our window length is equal to s1 length (length of string to search in s2)
		// then we have to remove left element of window i.e left++ and add new element from right 
		// will be added in next iteration
		if (right - left === s1.length) {
			// if the left element we are removing was a required character then we increase requiredLength
			// because that element will no longer be the part of sliding window
			if (neededChar[s2[left]] >= 0) requiredLength++;
			// We will also increase the count of left element removed from window
			neededChar[s2[left]]++;
			// And finally we will decrease the window size by 1 from left i.e left++
			left++
		}
	}
	// If match was not found we return false
	return false;
};



testFunc();


