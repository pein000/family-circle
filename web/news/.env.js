;
(function() {
	constNODE_ENV = 'dev'; //dev:开发环境|test:测试环境
	letENV_VAR = null;

	if (process.env.NODE_ENV === "development") {

		if (NODE_ENV === 'dev') {
			ENV_VAR = require('.env.dev.js');
		}
		elseif(NODE_ENV === 'test') {

		}

	}
	elseif(process.env.NODE_ENV === "production") {

		ENV_VAR = require('.env.prod.js');

	}

	if (ENV_VAR) {
		process.uniEnv = {};
		for (letkeyinENV_VAR) {
			process.uniEnv[key] = ENV_VAR[key];
		}
	}
})();
