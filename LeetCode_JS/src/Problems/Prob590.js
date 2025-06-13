const TreeNode = require('../DataStructs/_Node.js');
const TreeUtils = require('../Utils/TreeUtils.js');


/**
 * @param {_Node|null} root
 * @return {number[]}
 */
var postorder = function(root) {
    let eleArr = [];
	/**
	 * precondition:
	 * - eleArr exists and initialized
	 * 
	 */
	let postOrderTraverse = function(node){
		if (node === null) {
			return;
		}//fi
		for (let i=0; i<node.children.length; i++){
			postOrderTraverse(node.children[i]);
		}//rof		
		eleArr.push(node.val);
	};//end method
	
	postOrderTraverse(root);
    return eleArr;
};

var testFunc = function() {


	let root;


	console.log("ans: " + JSON.stringify(postorder(root)));
};



testFunc();
