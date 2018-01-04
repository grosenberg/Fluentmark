const path = require('path');
const webpack = require('webpack');

module.exports = {
	entry : './src/reactor.js',
	output : {
		filename : 'reactor.js',
		library : 'Reactor',
		libraryTarget : 'var'
	},
	module : {
		rules : [ {
			test : /\.(js|jsx)$/,
			exclude : /(node_modules)/,
			loader : 'babel-loader',
			query : {
				presets : [ [ 'env', {
					modules : false
				} ], ],
			},
		}, ],
	},
	plugins : [ new webpack.DefinePlugin({
		IN_BROWSER : true,
		'process.env.NODE_ENV' : '"production"'
	}), ],
};
