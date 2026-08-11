package com.oltpbenchmark.benchmarks.mytrace;

import com.oltpbenchmark.WorkloadConfiguration;
import com.oltpbenchmark.api.BenchmarkModule;
import com.oltpbenchmark.api.Loader;
import com.oltpbenchmark.api.Worker;
import com.oltpbenchmark.benchmarks.mytrace.procedures.GetUsuarios;
import java.util.ArrayList;
import java.util.List;

public final class MyTraceBenchmark extends BenchmarkModule {

  public MyTraceBenchmark(WorkloadConfiguration workConf) {
    super(workConf);
  }

  @Override
  protected List<Worker<? extends BenchmarkModule>> makeWorkersImpl() {

    List<Worker<? extends BenchmarkModule>> workers = new ArrayList<>();

    for (int i = 0; i < workConf.getTerminals(); i++) {
      workers.add(new MyTraceWorker(this, i));
    }

    return workers;
  }

  @Override
  protected Loader<MyTraceBenchmark> makeLoaderImpl() {
    return new MyTraceLoader(this);
  }

  @Override
  protected Package getProcedurePackageImpl() {
    return GetUsuarios.class.getPackage();
  }
}
