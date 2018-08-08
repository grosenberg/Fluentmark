## Class Test

@startuml
interface FileParser
interface Engine

class Configuration
class Collector
class Reporter
class Filter

PtraceEngine -up-|> Engine
BashEngine -up-|> Engine

BashEngine -down-|> FileParser

ElfParser -up-|> FileParser

Collector -- Engine : Sets/collects breakpoints
Collector -- FileParser : Receives file/line/address
Collector -- Reporter : Recieves executed lines

Reporter -- Writer : Reports executed lines
@enduml
