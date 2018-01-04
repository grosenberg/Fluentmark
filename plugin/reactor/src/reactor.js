/**
 * @preserve Copyright (c) 2017, Gerald Rosenberg, All rights reserved.
 * <p>
 * This source code is licensed under a 3-clause BSD-style license found in the
 * LICENSE file in the root directory of this source tree.
 * <p>
 * Derived from react-magic Copyright (c) 2014, Facebook, Inc. All rights
 * reserved.
 */
'use strict';

var HTMLtoJSX = require('./htmltojsx');
var JSXer;

/**
 * Creates a React component from the specified HTML. First converts the HTML to
 * JSX, then executes the JSX to create the virtual DOM.
 * 
 * @param {String} html HTML to convert
 * @return {Object} React virtual DOM representation
 */
function reactComponentFromHTML(html) {
    var jsx = '/** @jsx React.DOM */ ' + JSXer.convert(html);
    try {
        return JSXTransformer.exec(jsx);
    } catch (ex) {
        throw new Error('Something bad happened when transforming HTML to JSX: ' + ex);
        console.log(jsx);
        window.location.reload()
    }
}

/**
 * Renders the specified HTML to the body, by converting it to a React component
 * then rendering the component. Rather than blowing away and overwriting the
 * body, React will handle state transition from the existing state to the new
 * state.
 * 
 * @param {String} html HTML to render
 */
function render(html) {
    var processed = reactComponentFromHTML(html);
    React.render(processed, document.body);
}

/**
 * Ugly hacky way to find the body of the response.
 * 
 * @param {String} content Response from the server
 * @param {String} tag HTML tag to look for
 * @return {String} Content contained within the specified HTML tag
 */
function getTagContent(content, tag) {
    var tagStart = '<' + tag;
    var tagEnd = '</' + tag;
    var tagStartPos = content.indexOf(tagStart);
    var tagStartPos2 = content.indexOf('>', tagStartPos);
    var tagEndPos = content.lastIndexOf(tagEnd);

    var tagContent = content.slice(tagStartPos2 + 1, tagEndPos);
    return tagContent;
}

/**
 * Update the title and body of a page programmatically.
 * 
 * @param {String} full page content to load
 */
 export function update(content) {
 	document.title = 'Loading...';
 	document.body.classList.add('react-loading');
 	var body = getTagContent(content, 'body');
 	var title = getTagContent(content, 'title');
 	document.title = title;
 	render(body);
 	document.body.classList.remove('react-loading');
 }

/** Initialize */
function init() {
    JSXer = new HTMLtoJSX({
        createClass: false
    });
    var initialHTML = document.body.innerHTML;
    render(initialHTML);
    render(initialHTML);
}

document.addEventListener("DOMContentLoaded", function(event) {
    init();
});
