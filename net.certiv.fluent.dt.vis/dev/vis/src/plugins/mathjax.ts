// MathJax configuration
export function initMathJax(): void {
  injectMathJax();

  const config = {
    startup: {
      pageReady: () => {
        return mathJax()
          .startup.defaultPageReady()
          .then(() => {
            console.log('MathJax startup complete');
          });
      },
    },
    tex: {
      inlineMath: [
        ['$', '$'],
        ['\\(', '\\)'],
      ],
      displayMath: [
        ['$$', '$$'],
        ['\\[', '\\]'],
      ],
      processEscapes: true,
      processEnvironments: true,
      processRefs: true,
      tags: 'ams',
    },
    options: {
      skipHtmlTags: ['script', 'noscript', 'style', 'textarea', 'pre', 'code', 'annotation', 'annotation-xml'],
      processHtmlClass: 'math',
      ignoreHtmlClass: 'ignore_math',
    },
    svg: {
      fontCache: 'global',
    },
  };

  (window as any).MathJax = config;
}

// Manual rendering of an HTML element, or entire document if the element is null
export function renderMathJax(el: HTMLElement | HTMLElement[]): Promise<void> {
  if (!valid()) return Promise.resolve(undefined);

  //  promote a single element to an array
  if (el && !Array.isArray(el)) {
    el = [el];
  }

  mathJax().typesetClear();
  mathJax().texReset();

  return new Promise((resolve, reject) => {
    mathJax()
      .typesetPromise(el)
      .then(() => {
        resolve(void 0);
      })
      .catch((err: any) => reject(err));
  });
}

export function clearMathJax(): void {
  if (valid()) {
    mathJax().typesetClear();
    mathJax().texReset();
  } else {
    console.log('MathJax not ready');
  }
}

// Retrieve the injected MathJax instance
export function mathJax(): any {
  return (window as any).MathJax;
}

// Detect if a MathJax instance has been injected and is valid
export function valid(): boolean {
  const inst = mathJax();
  return inst && inst.version;
}

// Inject Mathjax into the document head
export function injectMathJax(): void {
  if (valid()) {
    console.log('Inject: MathJax already present in document!');
  } else {
    console.log('Injecting MathJax');
    const script = document.createElement('script');
    script.src = 'https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js';
    script.async = true;
    document.head.appendChild(script);
  }
}
