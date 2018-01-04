const path = require('path');
const webpack = require('webpack');

module.exports = {
	entry : './src/htmltojsx.js',
	output : {
		filename : 'htmltojsx.js',
		library : 'HTMLtoJSX',
		libraryTarget : 'umd'
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
