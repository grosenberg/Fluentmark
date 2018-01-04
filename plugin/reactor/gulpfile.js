var gulp = require('gulp');
var webpack = require('webpack');
var webpackStream = require('webpack-stream');
var htmltojsxConfig = require('./webpack.htmltojsx.config.js');
var reactorConfig = require('./webpack.reactor.config.js');
var uglify = require('gulp-uglify');
var rename = require('gulp-rename');

var BUILD_OUTPUT_DIR = '../resources/js/';

gulp.task('reactor', function() {
	return gulp.src('src/reactor.js').pipe(webpackStream(reactorConfig, webpack)).pipe(gulp.dest(BUILD_OUTPUT_DIR))
			.pipe(uglify({
				mangle : false
			})).pipe(rename({
				extname : '.min.js'
			})).pipe(gulp.dest(BUILD_OUTPUT_DIR));
});

gulp.task('htmltojsx',
		function() {
			return gulp.src('src/htmltojsx.js').pipe(webpackStream(htmltojsxConfig, webpack)).pipe(
					gulp.dest(BUILD_OUTPUT_DIR));
		});

gulp.task('default', gulp.series('reactor'));
