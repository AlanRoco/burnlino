alias generate_jar_file [path name block] { enter $path; do { jar cf $name . }; do $block ; exit }

generate_jar_file out/production/cobolin burnlino.jar { mv burnlino.jar ../../../burnlino.jar }
