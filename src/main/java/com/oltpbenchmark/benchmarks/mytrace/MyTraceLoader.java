package com.oltpbenchmark.benchmarks.mytrace;

import com.oltpbenchmark.api.Loader;
import com.oltpbenchmark.api.LoaderThread;
import java.util.ArrayList;
import java.util.List;

public final class MyTraceLoader extends Loader<MyTraceBenchmark> {

  public MyTraceLoader(MyTraceBenchmark benchmark) {
    super(benchmark);
  }

  @Override
  public List<LoaderThread> createLoaderThreads() {
    return new ArrayList<>();
  }
}
