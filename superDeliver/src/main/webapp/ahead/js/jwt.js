
const TOKEN_KEYs = "jwtToken";

/**
 * 将服务器返回的token存储在本地
 * @param token
 */
function setJwtToken(token){
	localStorage.setItem(TOKEN_KEYs,token);
}
/**
 * 获取本地的token
 * @returns token
 */
function getJwtToken(){
	return localStorage.getItem(TOKEN_KEYs);
}
/**
 * 移除token
 */	
function removeJwtToken() {
	 localStorage.removeItem(TOKEN_KEYs);
}
/**
 * 创建带Token  Header的请求头、
 * @returns
 */
function createAuthorizationTokenHeader(){
	token=getJwtToken();
	if(token){
		return {'Authorization':token}
	}else{
		return {};
	}
}
	