package remoting

import grails.plugins.*

class GrailsRemotingGrailsPlugin extends Plugin {
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.3.11 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "Grails Remoting" // Headline display name of the plugin
    def author = "Ben Woo"
    def authorEmail = "pursuer2002@sina.com"
    def description = '''To enable exposing grails services as spring remoting using the class's static expose attribute.'''
    def profiles = ['web']

    def artefacts = [ grails.plugins.remoting.InterceptorArtefactHandler ]

    def documentation = "http://grails.org/plugin/grails-remoting"

    Closure doWithSpring() { {->
        def helper = new RemotingPluginHelper()
        helper.registerBeans.delegate = delegate
        helper.registerBeans application
        }
    }

    void doWithDynamicMethods() {
        // TODO Implement registering dynamic methods to classes (optional)
    }

    void doWithApplicationContext() {
        // TODO Implement post initialization spring config (optional)
    }

    void onChange(Map<String, Object> event) {
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    void onConfigChange(Map<String, Object> event) {
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    void onShutdown(Map<String, Object> event) {
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
