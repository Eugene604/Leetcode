package Problems;

import java.util.*;

//time: Beats 99.05%, memory: Beats 93.34%
public class Prob1048 {

	public static void test() {
		String[] words1 = {"a","b","ba","bca","bda","bdca"};
		String[] words2 = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
		String[] words3 = {"abcd","dbqca"};
		String[] words4 = {"a","ac","acy","aucy","abucy","abaucy","abacucy","abacfucy","abacyfucy","abacyfucey","vabacyfucey","vabacyfbucey","vaubacyfbucey","vaubacyfdbucey","dvaubacyfdbucey","dvaubaccyfdbucey","a","ae","aey","ayey","ayeyd","adyeyd","avdyeyd","yavdyeyd","yadvdyeyd","yadvydyeyd","yadxvydyeyd","yadxvydbyeyd","yaydxvydbyeyd","yaydxvydbyceyd","yaydxvvydbyceyd","yaydxfvvydbyceyd","a","va","ava","eava","euava","euxava","euaxava","euavxava","euavvxava","eufavvxava","eufavvxazva","eufavvxcazva","eufavvvxcazva","eufdavvvxcazva","eubfdavvvxcazva","eubfdavvvxxcazva","a","ae","eae","eaze","beaze","ubeaze","ubeavze","ubeauvze","ubeauuvze","xubeauuvze","xubeabuuvze","xubeabuuvzze","xubeabuuvzzze","bxubeabuuvzzze","bxubeabuuvzzzey","bxubeabubuvzzzey","a","ba","cba","cbca","cbcay","cybcay","cybcday","cxybcday","cvxybcday","cvzxybcday","cvzxybecday","cvzxybecdayz","cvzxybecddayz","cvzxybeecddayz","cbvzxybeecddayz","cbvzxyubeecddayz","a","ab","azb","adzb","adzbf","adzbff","adzdbff","dadzdbff","dadfzdbff","dazdfzdbff","dazdfzdzbff","dazdfzdzbffb","dazddfzdzbffb","edazddfzdzbffb","edazddfczdzbffb","edazddfczdzebffb","a","af","ayf","dayf","dayfz","dayfzz","dauyfzz","ddauyfzz","ddauyfzzf","ddauyefzzf","ddauzyefzzf","ddauzyezfzzf","ddauzcyezfzzf","ddaduzcyezfzzf","ddaduzcyezefzzf","ddaduzccyezefzzf","a","ea","eda","eyda","euyda","euydza","eudydza","ueudydza","ueuddydza","ueuddydzaf","ueuyddydzaf","uveuyddydzaf","uveuydbdydzaf","uveuydbdydzabf","uveuydbddydzabf","uveuydbddydzvabf","a","ba","baa","ybaa","ydbaa","ydabaa","ydeabaa","uydeabaa","fuydeabaa","fuydeabaaz","fuydeaabaaz","fuydeaabaeaz","fuydeaabaeayz","fuydeaabaeayaz","fuydeaabaeaayaz","fuydeaabaeafayaz","a","ca","xca","xcxa","xcyxa","xucyxa","xucyxfa","xucyxxfa","xucyxxfaa","xucyxxfaca","xucyxxfuaca","xucyxxfuayca","xucxyxxfuayca","xucxdyxxfuayca","zxucxdyxxfuayca","zxucxdyxxfuaayca","a","au","uau","vuau","yvuau","yvuacu","yvuaucu","yvvuaucu","yvvuauzcu","yvvuazuzcu","yavvuazuzcu","yavvuafzuzcu","yavvuafzuzcuu","yavvuafzfuzcuu","yadvvuafzfuzcuu","yadvvuafzfuxzcuu","a","aa","aaz","eaaz","eaxaz","eaxavz","eadxavz","xeadxavz","xeaduxavz","xdeaduxavz","xdeaduxbavz","xdeaduxbavuz","xdeaduxbavuyz","xdeaduxbcavuyz","xdeaduxbcaxvuyz","xdeaduxbcaaxvuyz","a","ac","ace","avce","avcea","afvcea","afuvcea","afuvcead","afuvceadd","afyuvceadd","afyuvceaedd","afyuvceaexdd","afyuvceaexddx","avfyuvceaexddx","avfyufvceaexddx","avfyufvceaexvddx","a","za","zya","zyau","zyauu","zyauuv","zfyauuv","xzfyauuv","exzfyauuv","exzfyabuuv","eaxzfyabuuv","exaxzfyabuuv","fexaxzfyabuuv","fexaxzfxyabuuv","fexaxzfxyabuuvy","fexaxvzfxyabuuvy","a","ad","aud","aued","auecd","auedcd","ayuedcd","ayuedccd","ayuedccda","ayuedccdae","ayuedccddae","ayuedccddaex","aybuedccddaex","aybuedccfddaex","ayvbuedccfddaex","ayuvbuedccfddaex","a","da","eda","edad","edazd","ebdazd","ebdazfd","evbdazfd","evfbdazfd","evbfbdazfd","evbfbdazfdf","evbfbdazfduf","zevbfbdazfduf","zevbfbdazzfduf","zevxbfbdazzfduf","zevxbfbdazzfdufz","a","aa","aua","auau","auxau","auxauc","auxaubc","auxfaubc","auzxfaubc","azuzxfaubc","azuezxfaubc","yazuezxfaubc","yazueczxfaubc","yaazueczxfaubc","yadazueczxfaubc","yadazueczxfaubbc","a","xa","xax","xdax","xdbax","xdbaux","xdbbaux","xdabbaux","xxdabbaux","xxxdabbaux","xxxdeabbaux","xxxdeabbauxx","xxxdeaxbbauxx","xxxdceaxbbauxx","xaxxdceaxbbauxx","xaxxfdceaxbbauxx","a","ua","uax","uuax","uuavx","uuavxx","uubavxx","uubaxvxx","uubaxdvxx","uubaxdvyxx","uucbaxdvyxx","vuucbaxdvyxx","vuucbuaxdvyxx","vuucabuaxdvyxx","vuucdabuaxdvyxx","vuucdabuaxdvyxxb","a","ab","fab","fabu","fabzu","vfabzu","vfabzau","vfabzaub","vfabvzaub","yvfabvzaub","yvfabvzauyb","yvbfabvzauyb","yvbfabvezauyb","yvbfabveezauyb","yvbfabveezauyyb","yvbfabveezauyyab","a","ae","aee","aeue","aeuce","aeucee","aeudcee","aeudcaee","aeudcaeee","aeudcaeeee","aeudcafeeee","aeudcafeeeec","xaeudcafeeeec","xaeudcafeeeeyc","xaeudcafeeeveyc","xaeudcafeeeaveyc","a","ba","fba","fbda","fbdva","fbedva","fbedbva","fbcedbva","fbcedbvaa","fbcaedbvaa","fbcaedbvaaa","afbcaedbvaaa","zafbcaedbvaaa","zafbcavedbvaaa","zafbacavedbvaaa","zazfbacavedbvaaa","a","va","yva","yvya","yvyda","yvybda","yvybdab","yvybdaby","yvcybdaby","dyvcybdaby","dyvfcybdaby","dyvyfcybdaby","dyvyfacybdaby","adyvyfacybdaby","adfyvyfacybdaby","adfyvyfacybdabfy","a","az","vaz","vfaz","fvfaz","fvfavz","fvfavza","fxvfavza","fxavfavza","fxavvfavza","fxavfvfavza","xfxavfvfavza","xfxcavfvfavza","xfxcavfvfauvza","vxfxcavfvfauvza","vxfxcavfvfxauvza","a","za","zba","zaba","zabda","zaebda","zaebday","zaeabday","zaeabdauy","zaeabdaauy","zaeabdaauyc","zaeabdaauyyc","zaeabdavauyyc","zaezabdavauyyc","zaezabdavauyycy","yzaezabdavauyycy","a","fa","fca","fcav","fcdav","fcdaav","fcdaaxv","fcdaaxyv","ufcdaaxyv","ufcdaaxyvv","ufcdaxaxyvv","ufcdaxaxyvuv","ufcdaxaxdyvuv","ufcdaxaxdyyvuv","ufcdaxaxdyyvduv","ufcvdaxaxdyyvduv","a","ca","caa","caca","fcaca","yfcaca","yfacaca","yfacyaca","ycfacyaca","ycfacyazca","ycbfacyazca","ycbfacyazcca","ycbfacyazecca","ycbfacyazeccav","ycbcfacyazeccav","ycbcfacyauzeccav","a","ea","eca","exca","exdca","exdcaa","exdceaa","exdcueaa","ecxdcueaa","ecxdcueuaa","ecxdcueuaua","ecxdcueudaua","ecxdcueudaufa","ecxdcueufdaufa","ecxdcueufdaufax","ecxdzcueufdaufax","a","au","auy","azuy","azuyy","azuycy","eazuycy","eazuycye","eyazuycye","eyazyuycye","eyazyuycyeu","eyazyuyfcyeu","eyazyuyffcyeu","eyazyuyffbcyeu","eyazyuyffbcyedu","eyazfyuyffbcyedu","a","ca","cad","cadv","acadv","aycadv","uaycadv","uzaycadv","uzaycazdv","vuzaycazdv","vuzayccazdv","vuzayccazdve","vuzayzccazdve","vuzayzccfazdve","vuzayzccfuazdve","vuzavyzccfuazdve","a","ax","axb","axcb","axcxb","yaxcxb","zyaxcxb","zyaaxcxb","zyavaxcxb","zyavaxacxb","zfyavaxacxb","zfyavaxazcxb","zfyavaxazcxfb","zfyauvaxazcxfb","zfyauvaxazxcxfb","zfyauvaxcazxcxfb","a","ya","yya","yyda","yuyda","cyuyda","cyuyeda","cbyuyeda","cbyuyveda","cbeyuyveda","cbeyuyvedfa","cbeyuyvedfda","fcbeyuyvedfda","fcbeyuyvedafda","fcbeyuyvedaufda","fczbeyuyvedaufda","a","af","yaf","yafd","yafda","yafyda","yaefyda","yyaefyda","fyyaefyda","fyyaaefyda","fyyavaefyda","fyyyavaefyda","fyyyavaefydya","fyyyavaefydyae","fyyyavaefydyaea","fyyyavaefydxyaea","a","fa","fua","fuva","fuyva","fuuyva","fuuyvae","fuuyvzae","fuuuyvzae","fuuuyvzace","fuuuyvazace","efuuuyvazace","efuuuyvauzace","efuuuyvauzface","efuuuyvauzfacez","efuuuyvauzfacbez","a","aa","aab","faab","faaab","faaafb","faafafb","faafafbv","fbaafafbv","fbaafafabv","fbaafaffabv","xfbaafaffabv","xfbaafaffabvv","xfbaazfaffabvv","xfbaavzfaffabvv","xfbauavzfaffabvv","a","ay","aby","abxy","abxby","abxdby","abxydby","abxydbfy","abxydbfye","aybxydbfye","aybxydbvfye","aybxydbvufye","aybxydbvufaye","aybxydbvuufaye","afybxydbvuufaye","afybxyvdbvuufaye","a","ea","efa","defa","dvefa","dveyfa","dbveyfa","dbveyfua","dbveyafua","dbvveyafua","dbvvyeyafua","dbvvvyeyafua","bdbvvvyeyafua","bdbvvvyeyafbua","bdbvevvyeyafbua","bdbbvevvyeyafbua","a","ea","eea","eeae","eyeae","eyedae","eyedaeb","eyedaeub","eayedaeub","eayedaeeub","eayedaeeeub","eayedaeeeuyb","eayedaeeeuyxb","eayedaeeeuyxbv","eayedaeeeuyvxbv","eayedaeezeuyvxbv","a","va","vae","fvae","fvaye","bfvaye","bfvafye","bfvafyeb","bfvafyebd","bfbvafyebd","bfbvaffyebd","bfbxvaffyebd","bfybxvaffyebd","bfybxavaffyebd","bfybxavaffyebdc","bfvybxavaffyebdc","a","ba","fba","yfba","yfdba","yfdcba","yfzdcba","ayfzdcba","xayfzdcba","xayfzdcbba","xayfzdccbba","xayfzdccbbav","xayxfzdccbbav","xayxfzdccbbayv","xxayxfzdccbbayv","xxayxfzddccbbayv","a","da","dya","dyac","dayac","dayeac","dayveac","daydveac","daydveuac","daycdveuac","daycdveuaca","dbaycdveuaca","dbaycdvueuaca","dfbaycdvueuaca","dfbaycdvuefuaca","dfbayycdvuefuaca","a","ac","acc","acca","accxa","daccxa","daccyxa","daccyxac","dacxcyxac","dacxcyxacz","dxacxcyxacz","dxacxcyxuacz","dxeacxcyxuacz","dxeaycxcyxuacz","dxeaycxcydxuacz","dxeaycaxcydxuacz","a","ae","aef","eaef","aeaef","azeaef","azeeaef","azeeaeaf","azeeabeaf","azeeabeayf","azeeabeayyf","azeeadbeayyf","azeeadbueayyf","azeeadbueayyfc","azebeadbueayyfc","azxebeadbueayyfc","a","ua","uya","ubya","ubyda","ubydfa","zubydfa","zubydfaf","zeubydfaf","zeubydfafy","zeucbydfafy","zeucbyvdfafy","zeucbyvdyfafy","zevucbyvdyfafy","zevucbyvdyfayfy","zevucbyxvdyfayfy","a","ay","acy","aczy","acczy","accczy","accczzy","accczdzy","accczfdzy","aaccczfdzy","uaaccczfdzy","uaaccczfdzyu","uaaccuczfdzyu","uaaccuaczfdzyu","uaeaccuaczfdzyu","uaeabccuaczfdzyu","a","aa","aay","aayy","aayyc","aayycy","aayyccy","aayyccyz","aayycdcyz","aaayycdcyz","aaayyxcdcyz","aaayyxycdcyz","aaayyxycdcyzx","aaayyxyecdcyzx","aaayyvxyecdcyzx","aaayyxvxyecdcyzx","a","af","axf","eaxf","eaxfx","eaxafx","eaxafxa","eaxacfxa","eaxacfxaz","eaxacfxaez","eaxacfxaaez","eaxaccfxaaez","eaxacccfxaaez","eyaxacccfxaaez","eyaxacccfvxaaez","eyacxacccfvxaaez","a","xa","xaa","yxaa","yxbaa","yxbaba","yxbcaba","yxubcaba","yxvubcaba","yvxvubcaba","yvxvubecaba","yvxvuubecaba","yvxvauubecaba","yvxuvauubecaba","yvxufvauubecaba","xyvxufvauubecaba","a","av","acv","acvu","adcvu","audcvu","uaudcvu","uaufdcvu","uaufdxcvu","uaufdxcvzu","uaufdxcxvzu","xuaufdxcxvzu","xuaufdbxcxvzu","xuaufdbyxcxvzu","xuaufdbyxvcxvzu","xbuaufdbyxvcxvzu","a","da","dad","dcad","dcady","dcavdy","bdcavdy","bdcdavdy","abdcdavdy","abdbcdavdy","abdbcdaavdy","abdbcfdaavdy","abdbcfdaavdcy","abdbcfdaavdcby","abdbcfudaavdcby","abdbcfudaavdcbey","a","ua","eua","euea","xeuea","xecuea","xfecuea","xzfecuea","xzafecuea","xzaffecuea","xzaffecueaf","xzaaffecueaf","xzaabffecueaf","xzaabfffecueaf","exzaabfffecueaf","exzababfffecueaf","a","xa","yxa","yuxa","yuxca","yuxxca","yvuxxca","yvuxxzca","yvuxbxzca","yvuxbaxzca","yvfuxbaxzca","yvyfuxbaxzca","yvyfuxybaxzca","yvyfuxcybaxzca","yvyfuxcybfaxzca","yvyfduxcybfaxzca","a","au","aau","aayu","aayvu","avayvu","avaayvu","xavaayvu","xavaafyvu","xavfaafyvu","xavfaafyyvu","xavfaafyayvu","xavfxaafyayvu","xavfxaafyayvua","xavfxafafyayvua","xavfxafaafyayvua","a","ea","vea","vfea","zvfea","zvfexa","zvfeaxa","zvfeaxae","zbvfeaxae","zbvfeaxaae","zbvffeaxaae","zbvffceaxaae","zbvffceaxaade","zbvvffceaxaade","zbvvffceaxaadbe","zbvvffcebaxaadbe","a","az","azy","azfy","azfyf","azfycf","azfycxf","azfycxyf","zazfycxyf","azazfycxyf","azazzfycxyf","aazazzfycxyf","aazazzfycxyfv","ayazazzfycxyfv","ayazxazzfycxyfv","ayazxazzfycxyzfv","a","ca","cea","cdea","cdxea","cdxxea","cdbxxea","cdbxxxea","cdbxxxzea","cdbxxxzzea","cdbxxxzbzea","cdbxxxzbzdea","zcdbxxxzbzdea","zzcdbxxxzbzdea","zzcdbcxxxzbzdea","zzcdbcxxxzbzdeya","a","ax","axd","axda","axdau","axvdau","axavdau","axavcdau","axfavcdau","axfavcdauu","axfavcdfauu","axfavcdfauvu","axfavcdfauvyu","axfavcdfaucvyu","axfavvcdfaucvyu","axfavvcadfaucvyu","a","aa","aay","aacy","aaacy","aaacay","aaadcay","aaadycay","eaaadycay","eaaadycayd","eaaadycaydx","eaaavdycaydx","eaaavydycaydx","eavaavydycaydx","eavaavydzycaydx","aeavaavydzycaydx","a","au","aux","auxb","xauxb","xauxcb","xbauxcb","xbauxxcb","xbayuxxcb","xxbayuxxcb","xxbayuxdxcb","xxbayzuxdxcb","xxbayzuxdvxcb","xxbayzuxdfvxcb","xxbayzudxdfvxcb","xxbayzudxdfvxccb","a","ca","cda","dcda","dcdaa","dcdaac","dcdaaac","dbcdaaac","dvbcdaaac","dvbcdaaaxc","dvbcdaaaaxc","dvbcdaeaaaxc","dvbcdaeaaaxcv","dvbacdaeaaaxcv","dvbacdaeaaaxcvv","dvbacdyaeaaaxcvv","a","aa","aaf","aafv","faafv","fazafv","fazafzv","fazyafzv","bfazyafzv","bfazyafzxv","bfzazyafzxv","bfzazybafzxv","bfzazybdafzxv","bfzazybdcafzxv","bfzazybdcafzxev","bfzazybdcuafzxev","a","ad","cad","cxad","cxadd","cxaddy","cxadxdy","cxadexdy","bcxadexdy","bucxadexdy","abucxadexdy","uabucxadexdy","uabbucxadexdy","uabbucfxadexdy","uabbucfxadexudy","uabbucfxaedexudy"};
		String[] words5 = {"vu","adxabvaceddcfvbd","xcufzu","zufbud","bvzuvccyvafc","xxdyc","czdbyfeydeuxx","zavdf","baeafyuydav","avzud","vbucvxv","v","evcevuduf","ddvy","dfxxdezfddcyv","b","vedddezecdf","xxu","udcfuyufbdfdaba","fvuv","e","yfaazfzaaz","adb","ubxcfyx","byycfeuyxe","a","ddu","dxybz","cadycz","vcudvvueuazv","zdddfyy","ddxuy","dufd","vzbcdyuyy","bxevuvb","ezcuecyexduac","dudyfxbdzd","bu","fbbfufeaffzvbd","xaxzafa","zyfuay","vdvxavabcyc","dueve","yvcfe","vcvczedy","ffd","dev","vbfxaexx","xbazaa","z","ybvbfxyxufeceuux","eveuecdfdvfuzby","vbydezyaxz","xf","befyx","yccdcfcuzcuzz","bfduec","zuyyfyy","abfybvzy","ayvecf","bavf","abzxefdbvavbceax","ecuedaeyxeyb","bvde","v","cea","zbcex","fzxuzzycycye","zebacyuubbcuavu","duxdzve","ucefeudd","xbzzbubx","dddfb","fxuuavyxyzvbzfvx","eydyvvybfefffzzx","bxxuxfvbycyvbazy","yfd","yuavevbevebyzu","ezeudauubzc","euvfuvzyzd","zybadaucuacczu","cbx","vyeaxfavbb","vddbyd","yxudcd","xvebzza","fbbayyvevb","ubced","udczvddcb","yfuv","vdaeyxuaeyvadc","yfvxv","yfyzeezxcfuadae","cvydbudxbaxvbe","yuxfuxda","zyevxy","zayf","evafa","ee","afvvaexxcfaxavac","zyzcvaczdxaudaf","fczaxadddexzuy","xxcvebuzyb","dyxcfuyuaxv","efzbbvxaucyeu","zyyzdacbcbcdv","abcfy","yvfuavcxvvdyfuz","uzevdv","uxz","efefcfbde","zfv","ccfu","edby","bv","uzzueazcavbvdbdz","vyvefeuafazbu","y","xybevxcdz","yf","azzz","db","yzbydyfazcvuf","yeaabvzf","avzexxeuuaxfaz","vydzyzvx","zcyxdabzdfvzy","vvyeexebcedabud","fcaefudby","xzadcycc","cyduxxufax","dzaeaedbc","ceayevxubfxuycux","bvdavcfbdcaye","xvdav","uuavbxc","efxv","dbdyaxbdfcbzcx","z","zzfxbvab","byafuaubz","zuzxzff","bvvyudufu","xuazuvxedeuabz","ubv","bzuexydbfyfybb","xbvbdfuycuaebz","yeyd","vy","ddxffbux","zxyeebddvzze","bcdfx","eycyvbabbavvy","ecdyyvzd","uvccuzczfbdfad","zxeuf","ydxbzafcfuxffzcf","uzxyezdyfcfuu","eucxyfdfye","dfce","baay","vvxzvxuyvbecz","deeybbdeu","adxydadvyxz","ufczbdfcvzuecxf","cxyfx","cuvyfzfvbbcux","xuxaz","yvxufaf","zbxuxvvzfvefvu","fzdx","uuvccbcuvbzvdzuz","uxxbzxyabcazbdv","zvxfeufaxyvcvvz","uuf","ufeyxyebfaabx","ebvfbbyuedcbf","eaaeube","yzydbcd","zxbxexbxadfuxv","cybbvxdea","uxxzaa","vcufyd","vefufvub","c","euacduedfuxcubad","vuuyzc","xyuzaaaz","xcvdvadduadxeyb","xdxfybxzzxeeceea","ccv","xdydadxe","eyvvzyccvfczx","zazzyyae","du","baxdadacybybc","zbfef","cdfczcbaduucbbad","ebb","bbaaybxccevbxe","dyuyd","u","vydzfauaux","yexdxbxfv","c","uyybcudzxacyxxe","ddxdaaxdecxvccu","czyavvyyzy","vybadveaexzvfd","ceuufxxdexve","vfuafdbxdydxez","uexyuzbbcazve","zfbcxzfz","bdybccybyx","ad","zyueybadzdbe","cuxcdfbyfcddbxu","dfxxfz","eczbdexbad","ecduexev","xvbyfcuxc","xuczbyxcufffcc","deedv","xfeeduufccx","dbvyfeazccz","uyfzdbzuv","dbu","bbexbzuduyu","zyxacabbaexuucyd","fuazyebaf","fxdcuz","zavvfe","auvxzzavuyz","ueaey","vfcbvccuuyfv","zazuzyybbyc","euyvuevccebzyxaf","fxzxcdbzye","dfyzuydb","u","baabuzu","uabvvfb","xyfvafdvdvzaa","uvebzxba","vyu","bxueuvybxaz","afaafbbuxbdua","exuabybxazcbax","fxxdbc","dufby","xc","vfdzfxfeyxdedv","xbvaaybbae","fbz","devzubc","cfvvybauza","aef","zcfffa","bxuzvuecexvvc","fzxeuxfdccbuydfb","zdcybbaxv","avybzuf","f","vzxfuuuy","vzzzbfaabvy","zazfd","cxxdbavceuze","duccbe","czucfdvbebvaffzz","vxayz","yaefzavvyxx","bf","vdazbxdvuez","fzy","ezxd","ybeeyzuzbz","xbc","ueccybdybv","eadyabx","fa","ay","fcvzufddedzfcdxd","eecevffxb","ffzdazyxxyczadeu","dxdb","uav","yeubvezybdf","bcbyacexxuveccab","ezceveezexf","zazcycaaxyye","yyvauxd","evbvucebvuueb","beuv","zuuxvadzvy","zbddebbf","edbddyfeduv","xzc","fadxbvx","f","cv","vf","ffeaaxxea","zeddddfxazu","xc","bfyzvadcea","yz","avfyuazbba","zzexfyfzafvadya","ueeuceafzbxyb","fyadfu","ccv","cevccfzczdbzdcb","fyuyucdbvxe","vexycedbczeeuuva","bdbdxdvz","yzufvcffyb","f","vvxuvadzec","deaxbdc","ucyefcbfx","eaadyuabda","u","edxedu","uaz","c","xzadazcufcaedfa","feubuyu","eaxfefcufcvaabec","bafde","zcbcavuba","dydz","zadaacyvebyxvvzy","zayvu","xcfu","dxxvexfedzzz","z","dz","uxacfvffayebbyvb","va","dcafefxazvded","dbdddzzbbcdcefez","dcxfzxy","uy","fvyebdyca","vfax","yeaaz","bdeybzfcb","xdbxbec","d","vabvfadze","xczfab","fbxvfy","x","avyxuufuuyxfcubc","acabyyyzzc","xzy","xdczzcexbxy","bcfxx","aacdeb","bcubb","ycbxzvudxacaayv","yevzdevcvcvbvzz","zvb","uevzvzv","yzevcbbd","zcduuvfvvz","yyyx","byu","vfuvbddbzzz","cadfeyaucxyzvy","xueuadbd","ubd","uz","yuvuccxe","vcdbeyybc","bxbdcvazdczvbxfd","ebaueyzz","xcvyuz","vceebfava","bvdvxvuddyyuazy","uvcdfu","azyeyubaz","zbdczcadfdecdyea","ycdydezedvcbfz","fbecaedaazxzb","yyzdyevavzduac","xcdbuzz","cefdufebxxyx","bzba","xdcfcvfdxbyfeedv","aeyavuxuxvfb","zcceu","xzzbze","xuydzfxf","vcz","zeedbfefbzeaudyf","ueuaeyz","c","cdcauffbee","yyaevacfvzzevby","zyxxdbxudacaudb","fzebzcyfddyzffza","uybuyyeubcve","v","xffedv","vefuuccbf","uex","aczcabcx","bxuvdezee","deycybyuc","vczyxdyu","eb","cvafzczacfu","vaafazyczyayvz","ubzyue","dfabzybbfybx","vcxzcabucvu","vdeavucdefe","eu","xvddedxx","cuycuavbcucf","ezdubeufeeuxz","uz","dxcdxccfyfauxb","vvu","vuudczezdfzuue","aedyabcbyxeud","cbuubv","fdxe","cczaayze","ycfvedubxy","zafaedcdb","zbdefuavxuz","cbbf","xbyea","eedcxu","avffzb","vaffuvyazdzdxb","vfuaafbdyzzxxuav","dezeaffebdyya","yxbf","xzd","cvvbvxuvvvayvbb","yzdfzzfeexbyeau","cvuxzbeexdabeba","vfuzczaayufvfxa","vevudadfyzyv","ezzavyvefdx","ayb","x","dfcfccabzbayf","zf","uyddv","fbcuzdxfbbx","vuzuyxed","vduu","buaaefbduydeae","ubdbzbyv","xx","fz","yya","zuezeffyavdvdxx","byxcvved","x","vccyzyayxyxb","auxbaaeyx","cbzdcdcfevevxa","dubazbvebe","zucdzyb","zuaxcdzzu","bxuz","b","zauefuvcbdxfab","feevaxaczaubf","e","bzaduzy","dfyauyzaxyzcu","ubexfcd","buyv","xvz","evxezcdzfzbzadx","uzuuayxzxzuuuff","cxcfcv","ez","fazxffvz","ccuuevavzcfz","xz","c","aavzcdaxbyyyxb","ze","bxexyddvcyx","zeeb","abv","fbfzz","ayyfdud","yavvbvu","exxfeacbdvyfued","vafvzfyeexyf","ycde","zud","uyacfd","xyy","vdacvbud","zzayu","dxeuffuezbbc","yzcfavcavca","zeyzuaxcxyacz","cvdefdzfeccx","yudebeeyueua","xcazf","ce","ydevceeuyyyv","zycfec","zbc","azvecbvcvec","xybcebb","vcuuebcaxxdfc","bxdeebuuzxfzdbb","auydab","yv","fbecddby","vbb","audfuxv","avazb","dbadeva","zub","fzccyc","yzbd","x","beybcz","f","aaey","czeveecaudcfbbf","ufvffvbucbad","vvcdauyzczdc","uyzyxefux","vfzybeuebcyv","dybbufd","xudxbedbubbufuu","facdvaaevdaue","dxzdf","vddfxueb","yyaz","vvebxucdbz","facduuaaxxcxeeux","vczfbbdcyvavfdxb","fzcvzcxyxxyu","aduufucd","debu","vu","afdyydzcbzyfyf","dvcdfddce","yaafeeazecfbzexb","ybfxedxccaaadf","fzezufdzavz","acbbubxxeyxbcuc","ayczavbeb","zazuzbvvcez","yeyd","fuazyyfduvaxdeu","ya","yfa","fbv","edyfzeaeauyacfu","buezdzedx","uuuuuabudzyzzb","cu","faufdbbybaaz","exyzfeuecd","zveeayevz","ya","yyabzcvdfacvfvxy","eefeaeyu","aaaddbbavxdzye","e","ycfaddauvdceybbu","eueucxvfbucedy","v","xdcv","edybfvveb","zccffx","byuxbvbcxeb","exuzuevvaexey","uavcbdxbdyvvuy","ebucvfdyaaxaxev","efcffvauzu","yueubbvbcb","zefzz","vccevzzucx","axecffeyevvyzvey","xdxycydfyxbayfx","zavdxubzf","xxaxbcecuf","c","ddzcfuxceda","dxzxf","cacvvd","azbbbaxzevdf","zcvzddd","ybazxfdbf","yeuddcxdvx","f","yvfyefecydz","dceaczyuvyx","fdceavbduee","fefevzu","abyedaexbvabzzc","dazcef","bae","xxvdbfax","ezez","du","avvbzbczcfu","faaeavubfebebxv","b","zbyvxx","cyeevv","dvz","f","y","bxcuyebfdzzueada","uzaffexfcf","vcxvezczevze","abedbdvxu","avyev","vzxvucuv","fuvcyfzxc","uaxzdueefye","ebuxcyuxa","dzcucfebadev","dddxbbyfyba","dfvcuecxxybdxa","zxdafxvvbvzdb","f","zabeuzdfyfedb","vbfdbavcuauaxc","vez","x","abxzu","ue","afauefefy","dcadyxz","byddyazc","ufuzuvfz","zcbaebzzdv","f","ve","axyx","dzdbvvxdfb","uzebze","bbazavc","dzuaufzav","fbzevcxfuav","cbczbcauyf","ue","d","fz","cvyy","uuxzvu","ybd","xb","yaybxcbxzuuubzcf","cvvucd","aubvecdyb","uuydvfuxaucbzcd","ve","ydcfazye","yacfyvzufffdadyy","fddzbdbxzvfey","bdufyz","va","fxyxdffecybda","eudyvu","ccbvzabucxuyzb","fufvdyvzfubcfzaz","bzbbcczayfeyyyd","uuufx","vbeaevyfubd","ddaybxexd","ey","bayuezzdffdfyy","vvf","dzbaaxevfz","xccau","cyadfb","fcvfzvbzyzf","yycduefyucfbvufd","ezeeuzvzxaubyy","dcubevvxubayy","auvvze","cybxdevuvaexaxxc","zeebz","dyu","avyvbzdafdf","euzbfx","ffbbvvb","vz","byu","eebfcucfx","yexvveyfebfvczv","vdcfucyayzbeze","yeybuzvebfb","yc","faxdz","vu","fxzzyxazu","vdb","xdvyzvzycdzdzaxz","xxaxvcfcy","vbaxexdbvxax","adyayvvf","cyaauc","uaydaedv","fefcxbzb","yuzvauyecubuuff","caavvxubb","ycaycvuyubvfdvc","zvf","cebca","yuvcffdfeaevex","ddv","zyacuayzzzxybd","xbfzdbzbdxyx","vaabxb","xbuaauxfffdeu","zvbexyuafuxbbzu","baa","vxbcuacbazaybfv","avae","bzvzudxxf","xzdfdadcyuxvyfuy","bvucadeyxvyb","zcvbydax","ybzyavczf","auvdcuybv","c","dccxffzzyuvd","edxbddvceyubzud","babxa","vaeuxyevcuxyvz","bcuc","aaf","zxufxcvaecf","veac","vfcv","c","ceeuxc","fuxzy","zaedxd","xfycdfxxe","uczbxvefcfx","ufyabdffdcvyvyd","yuzzaeezce","ce","d","afbyxcefuybaba","bbzdu","uccvy","yd","bfyavdbycbyyauc","dvfxezaexbcf","u","a","bycyuxeavuv","vxubydcbev","ubee","acx","dbffedbcafyxy","vzezcaucuxdd","ebvca","fbaacbadvcbfybb","zuyd","av","xaaux","aexacx","x","badzvfaxd","xdddebbduvzd","uebzycfbebyzuf","auyccvxxd","efuxfuxeauczvyf","zydcavvayy","bb","fddv","cfcxaacuydadyxx","b","dacf","zeyzcazveb","zux","vuycu","cvxubdazcazuuad","ybbuvbuevzcbde","yzuduf","zyx","dcybuaubxdycffd","ceyuzxcdfexycyxu","uyuxzxzfx","zuvuyvefuvdxex","ecc","eezu","x","fuc","z","xzezvezxz","zex","zdxxucdvfdfdx","zeyxudzccacfzaf","afdufdxadeyzcdu","cxddabexzuazyu","yfxxf","bedadyaybauedaa","eezcczey","aedydudd","fffuvacyvyzxbvz","v","yxdau","aa","zd","eveucevayvba","vbbedbyadbae","ufvafauvdcyedazz","bvzexadddybz","zuaaudbcxufvuaab","zvxzz","ebfezacy","yvedv","bf","fezfd","dvvevfevbxuxfvy","bczdfxc","ucyzxddxxufeu","vyefvayvyyf","uueecuayedueyz","vubz","yyxvdx","ex","ueeyzcyxf","abfybffyx","vubxbezecbfy","debyvfzdf","uxbabueauxxaeabe","dbfyuufdbdazacyz","ueaxzeuvzcxfx","aafaxaecdcdzdc","vyzvy","axuabbyavaczxu","yvabbxbddv","zdyzbvveza","uazzzvx","vudf","vzbxvza","bdezdvf","uvxudaya","eyyuuffzacy","yaxzdzyv","uyvybaedveezudud","zedzbxaye","buaaacfefyavay","vacfxbubc","zdzccuudbycdvud","a","uuvybyu","acyzuuvdaxe","vuzfv","db","bvycazcuxyzzxz","vyzxuzuxbfvzbczy","a","vyz","czezbzxeybdfxbyf","cbbxa","fvzvueaacvufd","zca","vbuuubyxuzzx","cvvcfxbyczbbfx","b","fxec","adfx","aebvuexbyx","yxueudecdydc","yfyeyzfu","cfzzcebxybafy","vavyacauxedzeecz","budydzbvvuad","yd","vzuxavfa","dvvvcfv","fcxcubacdceacef","ebdbufe","avvd","ayudxdyzcu","efuyydx","fvbua","yzeyvfafcc","ye","fuzya","yaexbbuudfecyxvu","bd","zbuuavaadvx","dzdxecezfeuax","vyvaaxbee","vdufyuxz","zzzz","buvyzffvuzfev","aabvayucyaa","fxcdvdzbavbcyvzf","zubvvxcax","ccbd","zxvvvyx","eabxx","cucavczcbd","byazex","fzybbfcudx","axeufeeacbbbeae","xbcvveya","zxcubbybbf","ccfzaxb","dyuxyyzxbexaax","a","uvvdzux","vzbzbbxcxbefbfu","yb","duavy","cuvefyf","f","vzfdyeeufv","y","bfdbvuvabef","a","u","a","xxbefvyy","f","vb","zeuyfea","bdb","cde","bxxfbae","dfc","bxvecbd","ua","zucbbfyexcfyxu","bvfbecyxx","adfcuba","daddxadu","cbyexcycecuyv","e","fdaefuuvxfa","yxyfazabfz","yxbcbzezuvyzcz","aazebzcddffbvcz","ayazxuuuvbbz","vecvcvuzydyyedb","zfbaauyucayyezec","aefdzebxxza","vbzauf","acczvyxd","b","yuzycbzxcf","dfdb","zvy","udxaebuaduyfedxx","avavayvdxzzvxc","ydvcbaxxexez","ezbcxuufcyuxfda","dcxb","dabbuaxvduz","vbyc","zfxevcccvcueu","ecvy","dcfdeaaaubbcbxey","ydfbbvffzfveded","vxfzeef","ecvbyxab","cezxeycdu","euvxze","axcac","zcycvcf","azddduayfbdb","ccvzyuxedeuvzayf","bvuzdc","cfaedbv","xvfxc","e","vxzxcv","uxyzv","u","f","buvuzcyevdcvfxy","zvxfczbayeeyefux","zabvezexaz","cyxy","fau","zabzf","xudycuxb","fexfxfzb","bbvyyxcc","yaxxaab","bzv","vauycfzzffvz"};
		String[] words6 = {"xzdbfvb","eyddyyaddvzb","vzfcccxvvazdy","xdcfayybexv","zbbb","fadb","fxvveyazaxbz","v","ddzdabvx","ezzbvvuczxfeb","zydeuyvu","v","euc","evybeyua","zv","yyzvvbfzydzb","xvvbxcefdzxyxu","bdxaeuvzyay","cvaa","x","vxuydy","cyav","efdc","xuddedzufa","cczubeuxzvbuf","vccz","cudbxdaeyeb","vceubcxvezfxf","acdcdbcvyccezzf","xed","vaaebxdxux","ebccaxzea","xdxxuxeua","dz","z","dzeyfdaveuayxvv","eeudcuevvcbbubue","xudfdf","u","vdzbfzzy","bceduvubvfd","efuucxzbzz","bbyuzdcxbxeyvdzf","a","fdabb","aaazxueyeb","bebbffdxfyz","xvecdvzcvxc","cdeuxazcxx","azyvbcecyubxxex","accexacuecfa","vzubeuuyac","aeezadcazzuvdbb","uvxcycv","ufvyueayuuaa","ueyczzzzcbybae","ffxvd","xzxbceefxeuyux","xxdadfzxxe","bauv","acxyvbedfdayezxy","byzc","yyef","ufyx","zdyvaaybzvxzycd","yfazzfyyfc","fbv","zxbdxezbvdvvdey","xcczxbeddbueefe","yvc","fxazzvexe","bacaaafxvu","zefbudavyxuxvxx","yfbz","zud","fevydyayxezyy","fuvfcdyydud","zdedfa","uvbfdvydacxbedfb","azubu","uueddbyxx","exb","audu","vaayaccdeauxavez","zvbczv","uxdfdvzbaxaxe","uuzvfzucybfvevuy","xccevcudexdxvvac","zyedv","dbdca","azv","aczfbuubc","ebzfyzcevcvzczuc","va","dbuaaudfaduzzz","fzuceeyvvvbuez","fccuzyxxvfcvexab","decvydcuf","zddudyxxy","xdabzvzbeazuyby","bef","ucaeu","uebaceye","xfebczxyvzeuvy","abcbcazbazae","cxdyayxayfuydx","fvfbveuxbxxyuzu","z","xvayyfvdcecfczbd","zfecfyddcuyuzfu","xaxcfedfz","xvudbxcxfbubu","vdzxbxu","fdbbybcvdc","vxuxxcebddxzfycz","zzyvfvxbvyuvuuef","bbuvbbx","ufdebaaadeva","dedyucvabudvbvzx","fea","uvdyxxvyev","yzabzvdccbdx","aucvcevc","eyv","uefzva","cabcddbb","xyvebb","vubyvzcdafdxv","dycefzdzvedxf","evzzedy","veacbyefb","fycxvddfecxzvuea","zzzz","zbduez","bdzubyv","uzvvyuvay","cc","ufcvveaudbzybce","xeuz","eezbccdfevuu","yxu","uxf","zxecy","zzxcxbdduezf","zbdcb","xfydc","uyc","zeedufuffvuae","dvuyubzxvfayvxv","vvudueuyxbbyazdz","zaxyyau","zdcxdzfuy","zfdazyeczddefx","cde","ycb","y","baudzzzyb","ucx","dcfcveycdcuvua","zcuzxev","vbefazc","cbddbcfxbff","ydb","ubvdceezcvavdd","y","vevayveazafxxu","vudzyv","ceaxyfxdxxez","addcyeaeyexc","ucyudece","v","vz","buzdxyeuzyfzea","ebfu","dacvyxezzzv","yxcydyeucxcfb","eucdvvuafdbfcce","c","abebfc","zazud","vebbuubxacdax","xyxbefeu","byaduxev","fzvvvfdbaecfu","xduubcdayacfbyu","czyxe","dddu","ycvuyadcyuzxzey","xdya","efycyxfx","ybdaccb","ucaavybbbcyadfz","bfdevduexafdcbu","bfbddyevcd","aczadc","ead","cxa","yvezzxeeuvbafz","zufvfzux","bacufvdfea","eexfudfvcbvcuez","dyyfycyuyzufa","yxyzaaxzu","uvuccufvdvd","fcvyyc","xyxvzzexfa","beefzaeacvyfbb","ezuaxz","zadbcd","zbcfb","zud","dbc","xuczfyuzac","efdbzudfxdcua","dfb","ddduyef","zbazcbubxv","yzfzezufuyxzyz","yuycuzxeufvxeyf","veafycxvef","aycevb","zeebydbxc","auydecyudz","dcyccbzexczyuvb","udfzbbz","dxde","zvuzyvvcaz","vbfdbvyu","yyeauezy","zyxedfaefbd","xvuvuxfc","buuvc","xx","dyzudyxayyxbxeu","bduzvbuxvfyduvea","dayuvxezvvczeedx","yx","zz","exbyzxavbdvc","dvudevv","xbzzfxvc","eayafayfbzvv","yfayvvvzx","xbvcexyue","ydeuevacxava","dbuzu","eazccxzvzxzbd","ecz","bfyuezfayecddbxv","dfyzeyyz","xcbvdzzbxvxcx","avdyb","zaexxdzuzadbcuax","buyxzeyuedeayv","zv","fzdvvadxzxa","dx","efedzzcuc","xucef","vvbd","ffzv","bbeyxezebux","vuzvbd","ezydd","cafcfabdvuyyyxfv","xfzvfubvaxuy","z","ddzyyybacdb","zzcdvfdyaybcxyc","zvyzeeybdvy","bfavdxbxcf","xavyezauecbaa","cebyfvyyx","ybdcyue","cxz","beaeecfv","zvebcz","dcb","dudxaefuczb","vbaduvfzzcyvveux","aaxfffuxa","fxy","xbb","fecua","ffbyccey","dcu","uyvxee","vxfydcxavuz","yd","yfzv","fa","zdyxuvacvbdbd","cffcyfcxxuadyzv","fyedbfvvccv","bevcbxeacz","zayyccbecfxfe","zdvavczyaeexbb","uv","xzbxyyxvefecccuc","ezuebefvy","yaaexxaexyafdd","cvybxaydzu","ucfavcvvcyz","bfbxbbycvfv","yayafxyuxzxd","c","buvu","a","ccxdcxbyuy","dzdbuyxbx","vvvcvcxazzuzz","vzfxbbybdfb","bdfcauzfdebxe","xuebavy","cvbfbvdxyfccacxc","bzayydvdaex","zz","aaxueffvzdvxx","zyyfaev","xfxcu","ydxuubffyxvyzx","eaceudvufua","zfvyvezebdxecxfu","xxcefeaa","ufvvcda","vcdezbycfbcaaz","axfvzeufffzydebf","bycbdeyxd","exbubdyccx","ceexvvbdfydz","fzcu","cfxcevyfxx","bybudbxxubffvdze","dzxeyf","fdzveyuabua","avucxvbcfeyzubdx","byvuvdbvxzycxfye","bxfdfybf","z","eadczvcyvcxuxex","bvxzf","yyyydbaeybxyxu","z","cbzyefvvza","ccyb","afbxefxzcuau","eazzevvefyyyyaby","fyfvey","ed","zvdzuufxv","vvyvdvevavzb","uxefezdfdx","zcu","duaaexbyyxdbdcfa","zduxfzxaxv","evzccedxydfz","ccyaz","ydeazby","zbffxcyzvxydzbaz","fxbbffuaudxyz","ycvcbc","xubdvyvxucxxbyc","ueadf","bzdvzecyub","c","deyvfufacax","fe","byyvzbyaxxczzfy","ucuvxcyezeyy","axaaceuvexba","vabazez","e","avddezydfz","ueezczvzvueaec","cuvyu","zfuaucabezxf","ufzezuzxdabbfyz","xuuezc","zfav","xdv","bzfbfvuc","zfcbvufayeevdffe","yuucdfcfedz","vya","yaezf","fdeeabb","fcbeaayyy","dvfdxuyezfx","b","abcuvyvd","byaudazda","z","edyfxexxbxdzxx","cvadbex","ycfafzabbcufccvf","z","dvvbzfeezbuy","ydbuxddxefdxa","dvecvzbyafyayae","eufedffyvfxvy","yebyzzv","exx","uaaefffauade","uavzcby","x","cu","fux","evbdauuec","exuddebdexdfxu","cauebddfddxu","yyud","dafdcbzevuxe","eydevexuuuvyzx","cd","vvxyzbefxze","ebxyda","dcayzdayc","cxexvdaaxxdu","fayfuduuevxybd","xxz","fxcvefv","yz","dudxdfax","fcvcbeauac","e","zczbzaeyxzffd","bduazfaebyzx","cz","cbbyxdxc","cyeyffcyfa","fubfdyycdauybffv","deuvzzaxv","yx","vvy","uxfe","euacfavcavfv","uzf","ffuzbxxcxxu","xv","cduubzdudyv","zycycababcdvff","uffzv","zybvybubc","ebcxac","aaucav","ze","x","bzzdae","fxz","vfexbxz","dzvdaxcfxvxfaxzx","xzzuvuyexx","vvxauvded","zcybfccbvdxeyv","cdy","eyzbcz","aycbuvdfyyudfuc","cdvyxcbcxaz","ycyuce","eb","xefbuaeuydxbuaf","dabeedxxbx","ubycedcd","yazbyf","ucuddc","cevzfdyuyzuxeb","uuacuycdcdaxzzfx","vxy","vydxyabbzbvev","ebyxddxxfbzzz","bxubzdduux","yzyedvvvdzucd","xvebfcvauuvfyd","bax","uzcdayzvxvazyv","uy","cvdevuuvxycbd","dzfczdevdedxc","vcey","buv","bfecfdvdaebfav","cddzb","ebfbzvdyafcdx","zzyd","cc","zzxazzyzecv","bededcdubucdfyd","avxbc","dbffvbucdzzdfz","aefazxeueuyyxyz","u","bfbaadaz","zzdvba","dd","vafyc","vuufabxv","ccubafuzza","evbubceeeuduauu","ycbxvdfaxvd","d","ebxazae","dday","ubcdffffvxvfybf","yuuafvee","yebdxycexavz","xdzffaceddeb","dzdfuxeyyevcvbcx","uaxyezc","ebdd","cybevfeduzzucv","uczxeyf","uzaexvbccaaxacc","dfaz","fzvbfvaebua","bycvxdvzabyuyxb","cauxdcz","dzvzayauvafbye","abuyeyvfdvyafxy","xevxvycuv","uyzzax","bezezydfvy","ccczbcx","bbvaaxfuuvddxxbd","dbvzubc","b","zvuvuccedfdyvzbf","yb","y","vbaev","ubyyyxxxy","uyzadzzvzdcevy","cevvxadzevaee","yafdvxzdxzbfdxex","dbxfzeafcau","vevycadzvbexfu","cebzedcfzxfzzc","vzzeybcvaxad","bvyxycvdczby","abyubedbx","zfy","cbfzadzydxvxya","zaaf","faccdfuacfcczxe","uxdeczyzcbzb","de","xf","u","cvycdb","fxbydafab","duvc","afxcxuyccedzacex","z","zzbbzxcyzad","yvxzv","bd","eyuccyzvadxcfda","acefxfaxyxu","yazfeux","uavbybfyxbc","ebxyaxuvxa","dfbu","uv","beddzyy","d","azfzcxvxxxxx","eavbcvcbufbbacvu","uy","axyvcxvabcuc","fdeebcxb","zfduedyyac","u","ccfccyec","bz","euabedzvzuub","xbfa","fcuxfy","duza","vczzz","favazac","febyxf","bdevuxuabxdzvdu","eadauddexdx","c","yexfxbuubce","bevxfy","yuf","ufxx","aebcadbfzyvz","cvzafxczbaffycc","adaxeadfeauxxabb","vbxuzbybddufabcb","xvz","deybey","yebx","cuxubydzfzxafcc","zeeefxdczvydde","ucbvfudfdvxuu","vfabbvfaf","ea","fcdbzzaeub","bxaxyyy","bbdcecbbfvbebuzv","vfezubeuzuu","udfccybaeyfxeczd","ufzcvvdxfyd","udyxfeyfczza","ceuaz","uezzuffdadd","avcfvyxueaxxa","ea","vxyzfccdf","fufv","yyxfcdcyz","fzf","cxvzyufv","xcavvzd","xzzazxdfufybce","uaxauzd","yvca","xabybefzvefzaxx","avcv","ceevfexfzd","dbufubedebvveeee","uzdcf","vdz","duvzdauzaa","euzaezbxff","zxdzybcbuyffucxz","ayudyaecbf","fcyuxcbexfvcada","cbvzyvuaebcdc","xyzbzzfvaybuff","cdfuadb","yuuzabxbzz","yfbbffcedfuczaac","vbbduebc","cfuyauffu","cyvyeeddzvxcx","vxuvyafcxvbb","dzd","fcxzcuaavd","uxdcy","xvvybue","deuxvfax","ffcffdyvuexzv","zyezdaz","fbdvzedaubfvfdee","bayvcdexfydvcufc","da","uabu","yzcfvufd","udcvdu","vaudzbedxb","fxbvfxacbx","aexbaf","ybe","addfz","cxz","cc","bv","b","aa","aauvc","eyaxzdvufxzdxcx","zayzdyxzby","ycyxbcze","f","daxubfddbx","bvevyzvdxxxava","addu","yeuvbzuvduzcu","vbuyzaaaafbd","zdfxeyaxu","cafvuaeyuzvxefc","eebfbzz","zudufx","ubdxefdxddv","uf","cfucxavbe","beaac","vevcxxadbcybv","dfeav","eauedv","dvvfb","czexyevbubaxb","xaezffebccdcdccf","yey","yeuybvxvccycz","vfau","axdzxyauyzcxzbza","zcezduaz","dv","afcexvefczvcx","bxa","yxavedayavbb","udeeffzbbdefxy","yadbfcexdexvy","yevzf","cuvdedabdavduuv","deub","dff","uvvdeeuevyeyxyvc","aaxxa","vebazuxvfbxbau","uddeaez","zafcyfx","fbxbyyyfyudbv","bdbzcc","ey","vzfxcx","bfyfaacfecfcxa","euye","dbbyfbz","bucczyazad","acecdcbcuyd","cfbyzve","xzbbbdudazcxy","dvxfefx","zvffxdavdecavbyd","efavuye","bfufedfbedcvavc","cyfuybzvavvy","ccabf","vzazuecuufafuavz","dzzaxvdz","azuvyv","cd","dz","yvcxxduavdvdab","bbdfxzzuv","dveebee","cadaxvvbuubyc","cdc","ufffaev","zxdfxzvuubuaxufx","ydbfaddzaf","acaaexzxxbduv","ddazcbu","ccvxabyuuexe","euzazccufaa","ubczaazybd","cvzeyz","bcfae","bvbcxu","u","evfecyfxxabaavvz","xvaya","yeaex","deyxayzeyefeva","ecxb","zdbdee","avbdcvxyuuydxued","cby","cfbyeeyczzdbuba","cccv","dcdffcdvavu","edvufzea","dczyaeaeybzeu","ueubfybxzfczczx","xyfcufaaf","yxycudafb","fxa","fydexza","zuxubxyvv","eze","b","eudbcfzcvazdad","duyfebxcbadfz","uxbufdud","d","cvfxbbfaaxczevxd","ze","auzyzzd","vv","cuu","x","fzudvzyvufaxez","aexycfduvafcy","zbdd","zx","yzyu","xufuvbxebdbx","yfyvzyffbzavcxa","bydvxe","cydcebcazdxcxf","dz","yauxyafzb","fdbbxvyxzcuxfvf","ccvzfyfxbcueuvf","uedydfzccexcvbce","vyaeexyffzfuf","cdua","euuufzeazyfaecv","dufcyeud","zbbufyeydzvzvcec","fdxeu","bzvbudybza","zebvdu","vaxufcdbyccxyfbf","dcfb","xbbvbzev","uffxauuyvaae","ddeyxa","yeexfbx","cyzd","d","fv","cayffufycv","zzvduuyvvvv","y","ex","yef","evfazzzfuzay","uuvfcyfeebxycycb","zv","cbezyy","vbvxxcvdcfbucbz","azffvdyyx","fvedabaaeuyfyvv","y","ufxzyyyfyuuuyff","dyauuafzyade","ubxafyezbauazu","dcbey","ddbfeuvuyu","excaab","ayvebcfzva","vcvxfxv","zxabuaudxba","xfcefexabzvvc","dbfbyydbc","aydfffdaevyxe","zcczvdbez","fa","cxzafezcbxccby","xdcycxv","yycaybzbcbxfadv","xxv","vdfcyvycvyfav","bd","vduyze","axec","dfeaxfdef","eyecdvzucx","aavexufczbedeudf","eazzzezcxzeyza","zvzzxad","dvbaudyzzffvd","eaxdazz","bzfaceav","yavaxzfbzdafux","uuaebeb","xyfvzuxf","evdxea","czvbzxfyyuaaeeve","yuaeaad","c","fycxeuabdceducyv","yxz","eduaxebc","uea","zuvecbduvxxevzcf","yy","fdabaybbbuzcazx","dy","xfaebfeyvaabuxa","xyabd","vbvbzczbycf","faxxdvxdubzb","zafva","ydvbdvexax","fx","bcb","defuxyaad","xbxe","xb","xeuedeudfza","uduavxyxabfvb","yzeuduxyedaz","zuub","dyfvvxdzvubfy","uyzdabvzbd","zcffcxed","cceevv","eaydyyuezucx","xceda","ufcfx","avcf","acuvfcaaz","fbdfxf","efxeyedeadzve","xbyxzxzffxdecbzu","aadycbc","uxcdc","ffba","fxeauy","fbbxbcbfeayuy","afffyavvecbue","vxcaevccuacac","bzvf","c","dy","cvvbuzx","ccdy","zzxuzfeacvebbaby","x","acuuefz","ybbzdaebdczfdb","vzbevbxvzcy","dxzxcaybuvzdbdx","ufuzvydadcbduv","b","zfyffeueyyxedu","u","vyxzzeuaxyazd","ydvyf","fx","eyzazaxxvu","yydxcf","eueybuea","bavyacf","dzdufya","zvxfybayxay","xvazfvv","dvvf","fzaxzb","fyexcuc","yvuaayeyc","eabdacxdby","x","dvufxeczdfbcbb","yufbydcb","vf","xyv","azby","bebeafubeydv","xezbx","vdvyycuzza","xcz","favdebba","xexcvcxdvc","a","vzbbzzzva","a","bxyzacbexuyb","ub","dxaxf","cezyvaueyzdyf","faau","axcuxzvbzufxaf","cxazedbxevcfeueu","efffdfcabyvy","yeyy","vfff","dxxzbevbb","cfdcfuyxvy","e","bczcux","bfuefdz","fccfuzvc","yfeazcyddefabzve","bcvazazzvxadxuf","ezab","aczzayye","fddudxccb","ddx","ycfdzcdxbd","xe","vyeyzffazyuzd","ezxfxbzzuzz","vducebvacaafy","dcyavyxavffecxue","dfcyx","dzcaeee","xyaucbc","ezxvfyydc","xzzbczuvaezaeyfd","feyuyvcdy","vdeycyzaexaux","udbzffduba","c","fcxx","ezauycyvffaybfd","ybuaedfbxaaxbcx","fbvfczddvyezxcf","axxccvabddueef","xyxeua","xxaeecyvaxadyuc","yuyax","ceevvffaa","dyac","yvcyxzf","yxcfux","ybexecu","aevzacavbxyu","exabfdeb","addxdaadc","auyecfuxduxcda","aeuyvvdeyzfyvyc","zbxxcecyz"};
		String[] words7 = {"b","vb","ktttrh","rvqby","kttrh","bktttirhx","bktttrh","rvqb","ktrh","rvb","bktttrhx","cbktttirhx"};
		Solution1048 solObj = new Solution1048();


		String[] words;

		/*
		
		words = words1; //4
		System.out.println("words:�@" + Arrays.toString(words));
		System.out.println("ans=" + solObj.longestStrChain(words));
		
		words = words2; //5
		System.out.println("words:�@" + Arrays.toString(words));
		System.out.println("ans=" + solObj.longestStrChain(words));

		
		words = words3; //1
		System.out.println("words:�@" + Arrays.toString(words));
		System.out.println("ans=" + solObj.longestStrChain(words));

		
		words = words4; //16
		System.out.println("words:�@" + Arrays.toString(words));
		System.out.println("ans=" + solObj.longestStrChain(words));

		
		words = words5; //4
		System.out.println("words:�@" + Arrays.toString(words));
		System.out.println("ans=" + solObj.longestStrChain(words));

		
		words = words6; //4
		System.out.println("words:�@" + Arrays.toString(words));
		System.out.println("ans=" + solObj.longestStrChain(words));

		//*/
		
		
		words = words7; //7
		System.out.println("words:�@" + Arrays.toString(words));
		System.out.println("ans=" + solObj.longestStrChain(words));
		
		
	}// end method
	
	public static void test2() {
		String word1 = "bdca";
		String word2 = "xbc";
		String word3 = "bdc";

		
		Solution1048 solObj = new Solution1048();


		System.out.println("ans=" + solObj.isAPredOfB(word3,word1));
		//*/
		
		
	}// end method

	public static void main(String[] args) {
		test();

	}// end method

}

class Solution1048 {
	
	private static final int LARGEST_WORD_LENGTH=16;
	
	/*
	 * List of groups of words. Words are organized by word (string) size
	 * group id = word length
	 * Index of outer list is the group id, which is word size
	 */
	private List<List<String>> wordGroups;
	/*
	 * int [group id][word id] 
	 */
	private int[][] longestChainCache;
	
    public int longestStrChain(String[] words) {
    	populateDataStructs(words);

    	int globalLongestChainLength = 0;
    	int currChainLength = 0;
    	int minGroupID=1;
 
    	while(wordGroups.get(minGroupID).size()==0) {
    		minGroupID++;
    	}//end while    	
    	List<String> wordList;
    	for (int groupID = LARGEST_WORD_LENGTH; groupID>0; groupID--) {
			if (globalLongestChainLength==groupID-minGroupID+1) {
				return globalLongestChainLength;
			}//fi
    		wordList = wordGroups.get(groupID);
    		for (int i=0; i<wordList.size(); i++) {
    			if (longestChainCache[groupID][i]!=0) {
    				continue;
    			}//fi
    			currChainLength = getChainLength(groupID,i);
    			if (currChainLength>globalLongestChainLength) {
        			globalLongestChainLength = currChainLength;
        			if (globalLongestChainLength==groupID-minGroupID+1) {
        				return globalLongestChainLength;
        			}//fi
        		}//fi
    		}//rof
    	}//rof    	
        return globalLongestChainLength;
    }//end method      
    
    /**
     * precondition:
     * - required data structures are available and valid:
     *   wordGroups, predListCache, longestChainCache
     * - does not check for array bound
     * 
     * @param groupID - int, group if of current word
     * @param wordID - int, word id , also array index of the word in concern
     * @return the longest chain length from this word to lower groups
     */
    private int getChainLength(int groupID, int wordID){
    	if (longestChainCache[groupID][wordID]!=0) {
    		return longestChainCache[groupID][wordID];
    	}//fi
    	
    	int localMaxChainLength = 0;
    	int localChainLength = 0;
    	int nextGroupID=groupID-1;
    	String currWord=wordGroups.get(groupID).get(wordID);
    	String nextWord;
    	
    	for (int nextWordID=0; nextWordID<wordGroups.get(nextGroupID).size(); nextWordID++) {
    		nextWord = wordGroups.get(nextGroupID).get(nextWordID);
    		if (isAPredOfB(nextWord,currWord)) {
    			localChainLength = getChainLength(nextGroupID, nextWordID);
    		}//fi
    		if (localChainLength>localMaxChainLength) {
    			localMaxChainLength = localChainLength;
    		}//fi
    	}//rof
    	localMaxChainLength++; // +1 for itself
    	longestChainCache[groupID][wordID] = localMaxChainLength;
    	return localMaxChainLength;
    }//end method
    /**
     * postconditions:
     * - wordGroups populated
     * - empty predListCache with corresponding dimension populated
     * - isVisited instantiated
     * @param words - string array
     */
    private void populateDataStructs(String[] words) {
    	wordGroups = new ArrayList<>(LARGEST_WORD_LENGTH+1);
    	longestChainCache = new int[LARGEST_WORD_LENGTH+1][];
    	for (int i=0;i<=LARGEST_WORD_LENGTH;i++) {
    		wordGroups.add(new ArrayList<>(55));    		
    	}//rof
    	for (String word:words) {
    		wordGroups.get(word.length()).add(word);
    	}//rof
    	for (int i=1;i<=LARGEST_WORD_LENGTH;i++) {    		
    		longestChainCache[i]=new int[wordGroups.get(i).size()];    		
    	}//rof
    }//end method
    
    /**
     * is string A predecessor of string B
     * 
     * precondition:
     * - assumes non null string object
     * 
     * @param strA - String
     * @param strB - String
     * @return true if string A is precedessor of string B
     */
    public boolean isAPredOfB(String strA, String strB) {
    	if (strB.length()-strA.length()!=1) {
    		return false;
    	}//fi
    	int inxA=0,inxB=0;
    	while (inxA<strA.length()&&inxB<strB.length()) {
    		if (strA.charAt(inxA)!=strB.charAt(inxB)) {
    			inxB++;
    		} else {
    			inxA++;
    			inxB++;
    		}//fi    		
    	}//end while
    	
    	return (inxB-inxA)==1 || (inxA==strB.length()-1);
    }//end method
}// end class



